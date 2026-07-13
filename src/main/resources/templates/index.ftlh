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
        <h1 style = "text-align:center">Destiny 2 Characters</h1>
        <hr>
        <div class = "Search Bar">
            <form action="/characters" method="get">
                <input type = "text" name="keyword" placeholder = "Search characters by name or race" class = "form-search" value="${keyword?default('')}">
                <button type="submit" class="btn">Search</button>
            </form>
        </div>
        <div class = "container">
            <#list characterList as character>
            <div class = "cell">
                <div class = "Character">
                    <img src = "${character.thumbNail}">
                </div>
                <div>
                    <p class = "Charactername"><strong>Character Name</strong>: ${character.name}</p>
                    <p>
                        ${character.description}
                    </p>
                </div>
                <div class = "CharacterDetails">
                    <a href = "/chars/${character.characterid}" class = "btn">View Details</a>
                </div>
            </div>
            </#list>
        </div>
    </body>
</html>