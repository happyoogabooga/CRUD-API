package com.example.CRUDAPI.posts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class CharacterUiController {
    private final CharacterService characterService;

    public CharacterUiController(CharacterService characterService){
        this.characterService = characterService;
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/characters")
    public String getAllCharacters(@RequestParam(value = "keyword", required = false) String keyword, Model model){
        if (keyword != null && !keyword.isBlank()) {
            model.addAttribute("characterList", characterService.searchCharacters(keyword));
        } else {
            model.addAttribute("characterList", characterService.getAllCharacters());
        }
        model.addAttribute("keyword", keyword);
        return "index";
    }
    @GetMapping("/chars/{id}")
    public String getCharacterById(@PathVariable long id, Model model){
        Character character = characterService.getCharacterById(id);
        model.addAttribute("character", character);
        return "details";
    }
    @GetMapping("/new")
    public String createCharacterForm(Model model){
        model.addAttribute("character", new Character());
        return "new-character-form";
    }
    @GetMapping("/updateForm/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Character character = characterService.getCharacterById(id);
        model.addAttribute("character", character);
        model.addAttribute("title", "Update Character: " + id);
        return "update-character-form";
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable Long id, Character updatedCharacter) {
        Character character = characterService.updateCharacter(id, updatedCharacter);
        if (character != null) {
            return "redirect:/chars/" + character.getCharacterid();
        }
        return "redirect:/chars/" + id + "?error=true";
    }
    @PostMapping("/save")
        public String createCharacter(Character character) {
        Character createdCharacter = characterService.createCharacter(character);
        return "redirect:/chars/" + createdCharacter.getCharacterid();
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        boolean isDeleted = characterService.deleteCharacter(id);
        if (isDeleted) {
            return "redirect:/characters";
        }
        return "redirect:/chars/" + id + "?error=true";
    }
    
}