<div align="justify">

  <h1>Escalonamento</h1>

Em sistemas multi programados onde existem vários processos em execução que compartilham os mesmos recursos é fundamental que os sistema operacional execute a gerência do processador que permite garantir o uso adequado para atender os diversos processos em execução.
A partir do momento em que vários processos podem estar no estado de pronto, critérios devem ser estabelecidos para determinar qual deles será escolhido para fazer uso do processador. Os critérios usados para a escolha compõem a chamada política de escalonamento, que é a base da gerência do processador e da multi programação em um sistema operacional.

<br>

  <h1>Funções básicas da Política de Escalonamento de Processos</h1>

A política de escalonamento de um sistema operacional tem diversas funções básicas:

- Manter o processador ocupado a maior parte do tempo;
- Balancear o uso da UCP (unidade central de processamento) entre os processos;
- Privilegiar a execução de aplicações críticas;
- Maximizar o <a href="#throughput">throughput</a> do sistema;
- Oferecer tempos de resposta razoáveis;

**Cada sistema operacional possui a sua própria política de escalonamento adequada ao seu propósito**
<br>
<br>

  <h1>Rotinas de escalonamento</h1>

  <h2>Scheduler</h2>

A rotina Scheduler tem como função implementar os critérios da política de escalonamento (escalonador). Todo o compartilhamento do processador depende desta rotina.

  <h2>Despatcher</h2>

A rotina despatcher tem como função realizar a troca de contexto dos processos após o escalonador determinar qual processo deve fazer uso do processador. O tempo gasto com a troca de contexto do processo é chamado **latência do dispatcher**.
<br>
<br>

  <h1>Os critérios de escalonamento</h1>

A política de escalonamento depende das características do sistema operacional.
Em <a href="#tempo_compartilhado">sistemas de tempo compartilhado</a> o escalonamento trata todos os processos de forma igual, evitando, que um processo fique indefinidamente esperando pelo uso do processador.
Em <a href="#tempo_real">sistemas de tempo real</a> o escalonamento sempre prioriza a execução de processos críticos, com alta prioridade, em detrimento de outros processos.

Os principais critérios que são considerados em uma política de escalonamento são os seguintes:

- **Utilização do processador**  
  Quase em todos os sistemas é esperado que o processador esteja a maior parte do tempo ocupado.

  <div id="throughput">

- **Throughput**  
Throughput representa o número de processos executados em um determinado intervalo de tempo.
</div>

- **Tempo de Processador/CPU**  
  Se refere ao tempo que um processo leva no estado de execução durante seu processamento. A política de escalonamento não influencia este tempo que depende apenas do programa executado e do volume de dados processado.

- **Tempo de Espera**
  É o tempo total que um processo permanece na fila de pronto durante seu processamento, aguardando para ser executado.

- **Tempo de Turnaround**  
  Todo tempo que um processo leva desde a sua criação até seu término.

- **Tempo de Resposta**  
  Tempo decorrido entre uma requisição ao sistema e o instante em que a resposta é exibida.

Em todos os casos, uma política de escalonamento sempre busca otimizar o uso do processador e o throughput. Elas ainda podem ser classificadas segundo a possibilidade de o sistema operacional interromper um processo em execução e troca-lo por outro processo, atividade essa conhecida por **preempção**.

  <h2 id="tempo_compartilhado">Política de Escalonamento em Sistemas de Tempo Compartilhado</h2>

Nos sistemas de tempo compartilhado os usuários se comunicam com os sistemas, através de processos interativos, exigindo tempos de resposta baixos.

  <h2 id="tempo_real">Política de Escalonamento em Sistemas de Tempo Real</h2>

Em sistemas de tempo real, o escalonamento leva em consideração a importância relativa de cada tarefa da aplicação.
Se o tempo de resposta é crítico para determinada aplicação. ela deve ser executada em sistemas operacionais de tempo real onde é garantida a execução de processos dentro de limites rígidos de tempo, sem o risco de comprometer a tarefa a ser executada pela aplicação.
<br>
<br>

  <h1>Escalonamento Não-Preemptivos</h1>

O escalonamento **Não-Preemptivo** (o primeiro tipo de escalonamento implementado nos sistemas operacionais multi programados), um processo em execução somente sai desse estado quando termina seu processamento, ou caso ocorra um erro gerado por algum código do próprio processo.

  <h2>Escalonamento firts-in-first-out (FIFO)</h2>
Neste escalonamento o processo que chegar primeiro ao estado de pronto é selecionado para execução, todos os processos nesse estado são colocados em uma fila. Quando o processo em execução é colocado no estado de espera, o primeiro processo na fila de pronto é selecionado para execução.

<br>

  <h2>Escalonamento Shortest-Job-First (SJF)</h2>
Aqui o processo que tiver o menor tempo de processador é selecionado para execução.

<br>

  <h2>Escalonamento Cooperativo</h2>
Neste escalonamento o processo em execução na UCP pode liberar o processador, retornando à fila de pronto e possibilitando que um outro processo seja escalonado.

<br>
<br>

<h1>Escalonamento Preemptivos</h1>

No Escalonamento **Preemptivo** o sistema operacional pode interromper um processo em execução e passá-lo para o estado de pronto, para alocar outro processo na UCP.

  <h2>Escalonamento Circular</h2>
Projetado especialmente para sistemas de tempo compartilhado, ele é parecido com o escalonamento FIFO porém quando um processo passa para o estado de execução existe um tempo-limite para o uso do processador, desta forma temos uma fatia de tempo para cada processo, chamada time-slice.

<br>

  <h2>Escalonamento por Prioridades</h2>
Projetado para sistemas de tempo real, neste escalonamento o processo com maior prioridade no estado de pronto é sempre o escolhido para execução, e processo com valores iguais são escalonados seguindo o critério de FIFO.

<br>

  <h2>Escalonamento Circular com Prioridades</h2>
Este escalonamnto implementa o conceito de fatia de tempo e de prioridade de execução associada a cada processo.

<br>

  <h2>Escalonamento por Múltiplas Filas</h2>
Neste escalonamento existem diversas filas de processos no estado de pronto, cada qual com uma prioridade específica. Os processos são associados às filas em função de características próprias, como importância para a aplicação, tipo de processamento, área de memória necessária, etc.

<br>

  <h2>Escalonamento por Múltiplas Filas com Realimentação</h2>
Semelhante ao escalonamento por múltiplas filas, no entanto, aqui, os processos podem trocar de filas durante seu processamento. O sistema operacional coloca o processo na fila que é mais adequada para seu caso de forma eficiente de acordo com o comportamento do processo.

</div>
