package com.example.CRUDAPI.posts;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CharacterService {
  private final CharacterRepository characterRepository;

  public CharacterService(CharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }

  public List<Character> getAllCharacters() {
    return characterRepository.findAll();
  }

  public Character getCharacterById(long id) {
    return characterRepository.findById(id).orElse(null);
  }

  public Character createCharacter(Character character) {
    return characterRepository.save(character);
  }

  public Character updateCharacter(long id, Character updatedCharacter) {
    Character existingCharacter = characterRepository.findById(id).orElse(null);
    if (existingCharacter != null) {
      existingCharacter.setName(updatedCharacter.getName());
      existingCharacter.setDescription(updatedCharacter.getDescription());
      existingCharacter.setRace(updatedCharacter.getRace());
      existingCharacter.setUniverse(updatedCharacter.getUniverse());
      return characterRepository.save(existingCharacter);
    }
    return null;
  }

  public boolean deleteCharacter(long id) {
    if (characterRepository.existsById(id)) {
      characterRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public List<Character> searchCharacters(String keyword) {
    return characterRepository.findByNameContainingIgnoreCaseOrRaceContainingIgnoreCase(keyword, keyword);
  }
}