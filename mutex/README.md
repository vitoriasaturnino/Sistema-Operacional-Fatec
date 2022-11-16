<div align="justify">

  <h1>O que é Mutex?</h1>

Mutex ou exclusão mútua é uma técnica de sincronização que permite manter um acesso de exclusivo de leitura ou escrita de um recurso compartilhado por duas ou mais entidades, o que possibilita um maior controle sobre problemas que possam ocorrer em condição de disputa em regiões críticas.

Requisitos para que seja possível implementar o Mutex:
  - Duas entidades não podem estar nunca simultaneamente em suas regiões críticas;
  - Deve ser independente da quantidadee desempenhoi dos processadores;
  - Nenhuma entidade fora da região crítica pode ter esclusividade;
  - Nenhuma entidade eve esperar eternamente para entrar em sua região crítia.

Podemos vizulizar o esquema de Mutex também como um semáforo, onde quando a luz está verde a região crítica está livre para acesso, assim que a Thread 1 acessa a região o farol fica vermelho e não é possível que a Thread 2 entre na região.
Assim que a Thread 1 encerra o processo e sai da região crítica o faol volta a ficar verde possibilitando assim o acesso da Thread 2.

![Frame 2](https://user-images.githubusercontent.com/68754092/202202797-2bb908c6-9a01-4ac6-82a4-ca9b3b52fe01.png)

## Implementação [Mutex em Python](mutex.py)

#