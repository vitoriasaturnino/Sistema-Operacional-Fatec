 <div align="justfy">

# Memória Cache

## Historia/criação

O cache foi introduzido como a memória do processador em abril de 1965, pelo cientista da computação britânico Maurice Wilkes.

## Contexto/função

Cache é uma memória presente no processador com o objetivo potencializar o desempenho do chip de processamento.
Os dados e instruções de execução dos programas ficam em dispositivos de armazenamento (um HD ou um SSD). Assim que o usuário clica para abrir um programa e realiza uma função o SO busca no HD/RAM as informações necessárias e armazena na cache para que as funções possam ser executadas.

  <!-- Assim que o usuário inicia um programa a CPU envia o comando para o HD repassar os arquivos para a memória RAM, que tem maior velocidade de transferência de dados do que o HD, e pode se comunicar de forma mais rápida com o processador. Ainda assim, o processador passava bastante tempo ocissoso visto que a leitura e execução era mais rápida do que a memória RAM consegue entregar devido a distância, das trilhas e a velocidade de operação da RAM, fazendo assim necessária uma memória intermediária que otmize esse processo.-->

## Como funcionamento

A memória cache tem a função de otimizar o processo de troca de informações agindo como uma ponte que deixa a passagem de informações mais rápidas. O processador armazena os dados importantes para dar segmento a tarefa em sua memória cachê. Quando uma das parte da tarefa já foi concluida a CPU solicita mais dados para a memória RAM os armazena novamente uma parte no cache. esse loop se repete até o fim a ação. Por esse motivo a cache impacta diretamente na performance da máquina, pois diminu o número de requisições da CPU a memória RAM.  
 Em geral a cache tem alguns megabytes, enquanto a RAM tem gigabytes.
Fazendo uso da hierarquia de memória que é multi-níveis e tem diferentes tamanhos e velocidades.

Os níveis da memória cache são os seguintes:

- L1 é subdivido em duas partes, sendo um dedicado para instruções e outro para dados.
- L2 é programada para salvar dados e informações.
- L3 é uma memória de maior tamanho para salvar conteúdos “genéricos", que em princípio podem ser requisitados por quaisquer núcleos para dar continuidade às tarefas.

Quanto menor a capacidade de armazenamento é maior a velocidade com que ela trabalha pois está mais próxima do processador.

## Que tipo de informação vai pro cache?

a CPU verifca se o cache tem algum dado em determinado enderço, caso o dado seja encontrado (cache hits) CPU dá continuidade ao processo, caso não seja encontrado (cache miss) o SO tem a função de buscar o dado na memória principal a partir de um dado referênciado transfere um bloco de dados da memória principal para a cache.a partir de um dado referênciado transfere um bloco de dados da memória principal para a cache.  
 A comunicação entre cache e processador é feita no baixo nível, pela linguagem Assembly.

## Princípio da localidade:

O príncípio da localidade se baseia no fato de que em um intervalo de tempo, os endereços ocupados na memória por blocos de instruções de um programa, provem das interações, sequenciamento das instruções e suas estruturas. Sendo assim, convém armazenar os itens utilizados mais recentemente o mais próximo possível da CPU.  
 A utilização da hierarquia de memória no acesso à essas informações é bastante eficiente por satisfazer os seguintes princípos da localidade:

- localidade temporal, se um item é referenciado, é provável que seja referenciado de novo;
- localidade espacial, se um item é referenciado, é provável que seus vizinhos também o sejam.

#

## Referências

[Livro Arquitetura de Sistemas Operacionais](/Sistema-Operacional-Fatec/Tec-ARQUITETURA_DE_SISTEMAS_OPERACIONAIS.pdf)  
 [Contexto histórico/criação](https://historyofinformation.com/detail.php?id=834)  
 [Localidade](https://stringfixer.com/pt/Locality_of_reference)  
 [Hierarquia de memória](https://www.ic.unicamp.br/~ducatte/mc542/Arquitetura/arq_hp7.pdf)

https://razor.com.br/blog/hardware/memoria-cache-do-processador/#:~:text=A%20mem%C3%B3ria%20cache%20funciona%20como,que%20s%C3%A3o%20requisitados%20pelo%20usu%C3%A1rio

https://blog.maxieduca.com.br/memoria-cache-computador/#:~:text=A%20mem%C3%B3ria%20cache%20%C3%A9%20um,interrup%C3%A7%C3%A3o%20no%20fornecimento%20de%20energias

</div>
