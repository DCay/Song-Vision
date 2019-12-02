# SONG VISION
=================================================================
## Description
A platform for categorizing songs and audio tunes by similarity of genre, lyric style, music style etc. The main idea of the platform is for it to be completely client-driven.


## Data Models
These are the prototype data models. They may be subject to change, as the development goes on.

---
#### User
* Id
* Username
* Password
* Email
* Role
---
#### Song
* Id
* Name
* Duration
* Genre
* Link to Song
* Link to Text
* Thumbnail
---
#### Relation
* Id
* User
* Initator Song
* Affected Song
* List<Ratings>
---
#### Relation Ratings
* Id
* User
* Relation
* Similarity
* Comment
---
#### 