<div align="justify">

<h1>Memória Virtual</h1>

Memória virtual é uma técnica sofisticada de gerência de memória, onde as memórias principal e secundária são combinadas dando ao usuário a ilusão de existir uma memória muito maior que a capacidade real. O conceito dela fundamenta-se em não vincular o endereçamento feito pelo programa dos endereços físicos da memória principal; desta forma, programas e suas estruturas de dados deixam de estar limitados ao tamanho da memória física disponível, pois podem possuir endereços associados à memória secundária.  
Em ambientes que implementam memória virtual, o espaço de endereçamento do processo é conhecido como espaço de **endereçamento virtual** e representa o conjunto de endereço virtuais que o processo pode endereçar. Analogamente, o conjunto de endereço reais que o processador pode referenciar é chamado de espaço de **endereçamento real**.

#

<h1>Unidade de Gerência de Memória</h1>

A MMU (Memory Management Unit) é um módulo de hardware que faz o mapeamento entre os endereços lógicos e os endereços físicos da memória (RAM). Para isso, a MMU normalmente traduz número de páginas virtuais para número de páginas físicas utilizando uma cache chamada Translation Lookaside Buffer (TLB).

<!-- imagem de como o MMU funciona ou exemplo de TLB -->

O mecanismo de mapeamento permite traduzir um endereço localizado no espaço virtual para um associado no espaço real. Como consequência do disso, um programa não mais precisa estar necessariamente em endereços contíguos na memória principal a ser executado. O MMU é acionado sempre que se faz referência a um endereço virtual. Depois de traduzido, o endereço real pode ser utilizado pelo processador para o acesso à memória principal. Esta condição permite aumentar o compartilhamento da memória principal entre muitos processos

<!-- imagem memoria fisica + Tradução + memoria virtual -->

<br>

<h1>Principais técnicas de Memória Virtual</h1>

<h2>Paginação</h2>

É uma Técnica de gerência de memória onde o espaço de endereçamento virtual e o espaço de endereçamento real são divididos em blocos do mesmo tamanho, geralmete 4KB denominados **páginas**. No espaço virtual são chamadas de páginas virtuais e no espaço real páginas reais, frames/molduras. Todo mapeamento é realizado a nível de página, através de tabelas de páginas, em que cada página virtual do processo possui uma entrada na tabela ETP.

**Paginação por demanda**, quando um programa é executado, somente uma parte do seu código fica residente na memória principal, permanecendo o restante na memória secundária até o momento de ser referenciado.

**Paginação Antecipada** é o carregamento de páginas na memória antecipadamente, sendo que o sistema tenta prever as páginas que serão necessárias à execução do programa.

tamanho de página

<!-- A definição do tamanho de página é um fator importante no projeto de sistemas que implementam memoria virtual por paginação. Está associado a arquitetura de hardware e varia de acordo com o processador. Algumas arquiteturas permitem a configuração do tamanho de página, oferecendo maior flexibilidade. O tamanho de página tem impacto sobre o número de entradas na tabela de páginas e consequentemente no tamanho da tabela e no espaço ocupado na memória principal. Páginas pequenas necessitam de tabelas de mapeamento maiores e provocam taxa de paginação e aumentam o número de acessos a memoria secundaria. Apesar de paginas grandes tornarem menor o tamanho das tabelas de páginas, ocorre o problema da fragmentação interna. -->

proteção

Afim de preservar áreas de memoria do so e dos processos dos usuários existe a proteção.
Necessária para impedir que um processo, ao acessar uma página/segmento do sistema, a modifique ou mesmo tenha acesso a ela.
No esquema de memória virtual, cada processo tem sua própria tabela de mapeamento e a tradução dos endereços é realizada pelo sistema, impedindo assim, que um processo tenha acesso a áreas de memória de outros processos, a não ser que tenham compartilhamento explícito.
A proteção deve ser realizada em nível de cada página/segmento na memória, utilizando-se as entradas da tabela de mapeamento, com alguns bits especificando permissões a cada uma das páginas/segmentos.

<br>

<h2>Segmentação</h2>

Técnica onde o espaço de endereçamento virtual é dividido em blocos de tamanhos diferentes chamados segmentos, um programa é dividio logicamente e em sub rotinas e estruturas de dados, que são alocadas em segmentos na memoria principal.  
Normalmente, a definição dos segmentos é realizada pelo compilador, a partir do código fonte do programa, e cada segmento pode representar um procedimento, função, vetor ou pilha.  
O espaço de endereçamento virtual de um processo possui um número máximo de segmentos que podem existir, onde cada segmento pode variar de tamanho dentro de um limite.  
Os segmentos são mapeados através de tabelas de mapeamento de segmentos (TMS), e os endereços são compostos pelo número do segmento virtual (NSV) e por um deslocamento. Cada entrada na tabela de segmentos possuí o endereço do segmento na memória física, informações sobre seu tamanho, sua proteção e se está na memória ou não. A escolha da área livre a ser ocupada por um processo a ser carregado na memória pode ser a mesma utilizada no item Alocação Particionada Dinâmica (best-fit, worst-fit ou first-fit).

<br>

<h2>Paginação com Segmentação</h2>

Permite a divisão lógica dos programas e segmentos e, cada segmento é dividido fisicamente em páginas.
Um endereço é formado pelo número do segmento, pelo número de página contida nesse segmento e pelo deslocamento dentro dessa página.
O endereço físico é obtido somando-se a posição inicial do frame e o deslocamento.

<h3>Working Set</h3>

Working Set de um processo é o conjunto de páginas referenciadas por ele durante determinado intervalo de tempo, ou, segundo Denning, é o conjunto de páginas constantemente referenciadas pelo processo, devendo permanecer na memória principal para que execute de forma eficiente, evitando a elevada taxa de paginação (thrashing).
Sempre que um processo é criado, todas as suas páginas estão na memória secundária.
O Working Set deve Ter um limite máximo de páginas permitidas.

<br>

<h3>Realocação de Páginas</h3>

O maior problema da gerência de mv por paginação é decidir quais páginas liberar. O Sistema Operacional deve considerar se uma página foi ou não modificada antes de liberá-la para outro processo, caso contrário, possíveis dados armazenados na página serão perdidos.
Sempre que uma página é alterada, um bit de modificação é alterado de 0 para 1, informando que a página foi alterada. A Melhor estratégia de realocação é escolher uma página que não será referenciada num futuro próximo. Porem maior overhead para o so implementa-lo

Principais estratégias usadas pelos sistemas operacionais para realocação de páginas:

- **Ótimo**
  O algoritmo ótimo seleciona para substituição uma página que não sera mais referenciada no futuro ou aquela que levara maior intervalo de tempo para ser novamente utilizada.

- **Aleatória (random)**
  Não utiliza nenhum critério de seleção.
  Consome menos recursos do sistema.
  Raramente é utilizada.

- **First-In-First-Out (FIFO)**
  A página que primeiro foi utilizada será a primeira a ser escolhida.
  Implementação bastante simples.
  Necessário apenas uma fila.

- **Least-Recently-Used (LRU)**
  Seleciona a página utilizada menos recentemente, ou seja, a que está há mais tempo sem ser referenciada.
  Estratégia boa, mas pouco implementada;
  Grande overhead causado pela atualização, em cada página referenciada, do momento do último acesso, além do algoritmo de busca dessas páginas.

- **Not-Recently-Used (NRU)**
  Escolha da página que não foi recentemente utilizada (semelhante ao LRU).
  Flag de referência – indica quando a página foi referenciada ou não.
  Inicialmente, todas as páginas estão com o flag = 0, à medida que as páginas são referenciadas, o flag é modificado para 1.

- **Last-Frequently-Used (LFU)**
  Escolhe a página menos referenciada.
  Existe um controle do número de referências feitas às páginas.
  É escolhida a página que o contador tem o menor número de referências.
  Problema – As páginas que entrarem mais recentemente no working set serão as que estarão com o menor número no contador.

<br>

<!--

<h3>Proteção</h3>


<br>

<h3>Compartilhamento de Memória</h3>

Bastante útil para programas de código reentrante.
Bastante simples implementação do compartilhamento de código e dados entre vários processos, bastando que as entradas das tabelas de páginas/segmentos apontem para as mesmas páginas/segmentos na memória principal.
Reduz o número de programas na memória principal e aumenta o número de usuários compartilhando o mesmo recurso.

Segmentação X Paginação em relação ao compartilhamento:
O compartilhamento de segmentos é mais simples que o de páginas, pois as tabelas de segmentos mapeiam estruturas lógicas, como sub-rotinas e estruturas de dados.
Enquanto o mapeamento de um vetor necessita de várias entradas na tabela de páginas, na tabela de segmentos é necessária apenas uma única entrada.
O segmento pode variar seu tamanho durante a execução com o crescimento de um vetor, por exemplo, na paginação, isso implica na alocação de novas páginas.

Entretanto existem também problemas na fragmentação:
- Paginação - problema da fragmentação interna
- Segmentação - problema da fragmentação externa.

<!-- Swapping em Memória Virtual
Quando existem novos processos que desejam ser processados e não existe memória real suficiente, o sistema seleciona um ou mais processos que deverão sair da memória para ceder espaço aos novos processos. Os critérios mais utilizados para a escolha são a prioridade, escolhendo processos de melhor prioridade, e o estado do processo, selecionando os processos que estão no estado de espera.

Thrashing
É a excessiva transferência de páginas/segmentos entre a memória principal e a memória secundária. Problema existente tanto em paginação quanto a segmentação.

<h2>Na paginação</h2>

**A nível de processo:** O working set de um processo pode ser pequeno demais para acomodar as páginas constantemente acomodadas referenciadas por ele, a solução é aumentar o tamanho do working set.
O thrashing também pode ocorrer pela não obediência do conceito da localidade, ou seja, o programa faz referência a comandos/dados localizados em páginas fora do working set do processo e a solução para isso é reescrever a aplicação.

**A nível de sistema:** O trashing ocorre quando existem mais processos competindo por memória que espaço disponível.
O primeiro passo é a redução do tamanho dos working set dos processos, mas isso pode levar o thrashing a nível de processo.

**Na segmentação:** Em nível de processo, quando a transferência de segmentos é excessiva devido a modularização extrema do programa não seguindo o conceito da modularidade.
Em nível de sistema é semelhante ao caso da paginação.
Em qualquer caso, se existem mais processos para serem executados que a memória real disponível, a única solução é expandir a memória principal.
Este problema ocorre em todos os sistemas que possuem um mecanismo de gerência de memória.

<br>

<h1></h1>

<br> -->

#
