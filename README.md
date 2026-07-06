# API-Endpoints
All endpoints use the base URL: `http://localhost:8080/api/posts`
### 1. Get All posts
```http
GET /api/posts
````
**Response**
```json
[
    {
        characterid: 1,
        description: "A chaperone weilding human, and suprisingly not a light bearer.",
        name: "Amanda Holiday",
        race: "Human",
        universe: "Destiny"
    },
    {
        characterid: 2,
        description: "The explorer of the infinite forest, and great friend of Saint XIV",
        name: "Osiris",
        race: "Human",
        universe: "Destiny"
    }
]
```
## 2. Get Post by ID
```http
Get /api/posts/{id}
```
### 3. Create a New Post
```http
POST /api/posts
request body:
{
    "name": "Character_name",
    "description": "Description of character",
    "race": "Race of your character",
    "universe": "The universe your character is from"
}
```
**Response**
```json
{
    "characterid":3,
    "description": "Description of character",
    "name": "Character_name",
    "race": "Race of your character",
    "universe": "The universe your character is from"
}
```
### 4. Update an Existing Post
```http
PUT /api/posts/{id}
request body:
{
    "name": "Updated character_name",
    "description": "Updated description of character",
    "race": "Updated race of your character",
    "universe": "Updated universe your character is from"
}
```
**Response:**
```json
{
    
    "characterid":3,
    "description": "Updated description of character",
    "name": "Updated character_name",
    "race": "Updated race of your character",
    "universe": "Updated universe your character is from"
}
```

### 5. Delete a Post
```http
Delete api/posts/{id}
```
**Response** <Empty>
### 6. Search Post by Name or Race
```http
GET /api/posts/search?query=Osiris
```
**Response**
```json
[
    {
    "characterid": 2,
    "description": "The explorer of the infinite forest, and great friend of Saint XIV",
    "name": "Osiris",
    "race": "Human",
    "universe": "Destiny"
    }
]
```