# Library
This project purpose is to enhance my skills on Java.
This is a console app.

# Structure
```
├── .idea
├── _config.yml
├── src
|   ├── com
|      ├── Library
|         ├── Autor
|         ├── Biblioteca
|         ├── Library
|         └── Livro
|   ├── Resources
|       └── Biblioteca.txt
├── Biblioteca.iml
└── README.md
``` 
# Methods and their functions
``Library.java``
- Getters
  - getPath: returns path of file that keeps all books of "database"
  - getLivrosLista: returns books list
- Setters
  - setPath: changes the path of file
  - setLivrosLista: sets a list of book
- Others
  - idCadastro: returns how many books are been kept in the database
  - atualizarLista: updates list according to the file that keeps the data
  - cadastrarLivro: saves a book by the user
  - doarLivro: donates a book that is already saved
  - exibirLista: shows the list of saved books
  - retirar: the user takes a book
