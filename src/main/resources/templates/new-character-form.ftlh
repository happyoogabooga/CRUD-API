<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/style.css">
    </head>
    <body>
        <nav>
            <ul>
                <li> <a href = "/characters">HOME</a>
                <li> <a href = "/about">About</a>
                <li> <a href = "/new">Add a Character</a>
            </ul>
        </nav>
        <div class = "new-character-form-container">
            <div class = "new-character-form-top">
                <h1>Add a New Character</h1>
                <p>Expand our love for Destiny!</p>
                <hr>
            </div>
                <div class = "new-character-form-bottom">
                <h3>Character Information</h3>
                <form id = "CharacterForm" action="/save" method="post">
                    <div class = "CharacterForm-Fields">
                        <label for = "CharacterName" class = "Form-Label">
                            <strong>Character Name</strong>
                        </label>
                        <input type = "text" id = "CharacterName" name = "name" placeholder = "e.g., Ikora rey" required class = "form-control" value="${character.name?default('')}">
                        <small>The name of your character</small>
                    </div>
                    <div class = "CharacterForm-Fields">
                        <label for = "Universe" class = "Form-Label">
                            <strong>Universe</strong>
                        </label>
                        <input type = "text" id = "Universe" name = "universe" placeholder = "e.g., Destiny" required class = "form-control" value="${character.universe?default('')}">
                        <small>The name of the universe your character is from</small>
                    </div>
                    <div class = "CharacterForm-Fields">
                        <label for = "Image-URL" class = "Form-Label">
                            <strong>Image URL</strong>
                        </label>
                        <input type = "text" id = "Image-URL" name = "thumbNail" placeholder = "https://example.com/sloane.jpg" required class = "form-control" value="${character.thumbNail?default('')}">
                    </div>
                    <div class = "CharacterForm-Fields">
                        <strong>Race of your character</strong>
                        <br>
                        <input type="radio" id="Awoken" name="race" value="Awoken" <#if character.race?exists && character.race == "Awoken">checked</#if>>
                        <label for="Awoken">Awoken</label>
                        <input type="radio" id="Exo" name="race" value="Exo" <#if character.race?exists && character.race == "Exo">checked</#if>>
                        <label for="Exo">Exo</label>
                        <input type="radio" id="Human" name="race" value="Human" <#if character.race?exists && character.race == "Human">checked</#if>>
                        <label for="Human">Human</label>
                        <input type="radio" id="Cabal" name="race" value="Cabal" <#if character.race?exists && character.race == "Cabal">checked</#if>>
                        <label for="Cabal">Cabal</label>
                        <input type="radio" id="Fallen" name="race" value="Fallen" <#if character.race?exists && character.race == "Fallen">checked</#if>>
                        <label for="Fallen">Fallen</label>
                        <input type="radio" id="Vex" name="race" value="Vex" <#if character.race?exists && character.race == "Vex">checked</#if>>
                        <label for="Vex">Vex</label>
                    </div>
                    <div class = "CharacterForm-Fields">
                        <label for = "shortDescription" class = "Form-Label">
                            <strong>Short-Description</strong>
                        </label>
                        <textarea id = "shortDescription" name = "description" placeholder = "describe your character in 1-2 sentences" rows = "3" required class = "form-control">${character.description?default('')}</textarea>
                        <small>A brief summary of your character (50-100 words)?</small>
                    </div>
                    <div class = "CharacterForm-Fields">
                        <label for = "shortDescription" class = "Form-Label">
                            <strong>Personality Description</strong>
                        </label>
                        <textarea id = "personalityDescription" name = "personality" placeholder = "describe your character's personality in 1-2 sentences" rows = "3" required class = "form-control">${character.personality?default('')}</textarea>
                        <small>A brief summary of your character (50-100 words)?</small>
                    </div>
                    <div>
                        <button type = "submit" class = "submit-btn">Add Character</button>
                        <a href="/characters" class = "btn">Cancel</a>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>