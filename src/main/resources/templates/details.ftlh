<!DOCTYPE html>
<html>
    <head>
        <link rel = "StyleSheet" href = "/style.css">
    </head>
    <body>
        <nav>
            <ul>
                <li> <a href = "/characters">HOME</a>
                <li> <a href = "/about">About</a>
                <li> <a href = "/new">Add a Character</a>
            </ul>
        </nav>
        <div>
            <div class = "Outside-Container-Details">
                <a href = "/characters" class = "btn">Back to Gallary</a>
                <div class = "Container-Details">
                    <div class = "Left-Details-Column">
                        <div class = "Details-Img-Container">
                            <img src ="${character.thumbNail}" class = "Detail-Img">
                        </div>
                        <div class = "Details-Card">
                            <div>
                                <p>Quick info</p>
                            </div>
                            <div class = "Sub-Container-Details">
                                <h2>${character.name}</h2>
                                <hr>
                                <p>
                                ${character.description}
                                </p>
                                <strong>Universe:</strong>
                                <p>${character.universe}</p>
                                <strong>Race:</strong>
                                <p>${character.race}</p>
                            </div>
                        </div>
                    </div>
                    <div class = "Right-Details-Column">
                        <h1>Backstory</h1>
                        <p>
                            ${character.description}
                        </p>
                        <h1>Personality</h1>
                        <p>${character.personality}</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>