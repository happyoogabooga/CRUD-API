package com.example.CRUDAPI.posts;
import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/characters")
public class CharacterApiController {

  private final CharacterService characterService;

  public CharacterApiController(CharacterService characterService) {
    this.characterService = characterService;
  }

  @GetMapping
  public ResponseEntity<List<Character>> getAllCharacters() {
    List<Character> characters = characterService.getAllCharacters();
    if (characters.isEmpty()) {
      return ResponseEntity.ok(Collections.emptyList());
    }
    return ResponseEntity.ok(characters);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Character> getCharacterById(@PathVariable long id) {
    Character character = characterService.getCharacterById(id);
    if (character != null) {
      return ResponseEntity.ok(character);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
    Character createdCharacter = characterService.createCharacter(character);
    return ResponseEntity.ok(createdCharacter);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Character> updateCharacter(@PathVariable long id, @RequestBody Character updatedCharacter) {
    Character character = characterService.updateCharacter(id, updatedCharacter);
    if (character != null) {
      return ResponseEntity.ok(character);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCharacter(@PathVariable long id) {
    boolean deleted = characterService.deleteCharacter(id);
    if (deleted) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/search")
  public ResponseEntity<List<Character>> searchCharacters(@RequestParam String query) {
    List<Character> characters = characterService.searchCharacters(query);
    if (characters.isEmpty()) {
      return ResponseEntity.ok(Collections.emptyList());
    }
    return ResponseEntity.ok(characters);
  }
}