# Spooling

<div align="justify">
  
A técnica de spoopling foi criada com o intuito de de aumentar o grau de eficiencia e concorrencia de um SO, já que na década de 50 a velocidade de operação entre os dispositivos de I/O era menor que a do processador deixando-o ocioso por algum tempo.
A solução para a época foi armazenar jobs em fitas magnéticas e submete-las a processamento Isso posibilitava que a CPU executasse os jobs de forma sequencial; ao invés de um job gravar sua saida na impreseora a gravação poderia ser feita em outra fita, que posteriormente poderia ser impressa integralmente.

No entanto, como o processamento dos jobs era feito de forma sequencia1 (FIFO), o que causa outro contratempo, já que se algum job tiver um tempo de processamento muito longo, os demais teriam que esperar que seu processamento fosse concluido para enttão, por sua vez, serem processados. Isso pode ser relvido com dispositivos de acesso reto, como discos, que proporionavam o processamento não sequencial, tornando o spooling mais eficiente.
Assim como a tecnica de buffer, o spooling faz algo parecido utilizando uma área do disco enquanto processos são executados concorrentemente.

Atualmente essa técnica é utilizada no gerenciamento de impressão. No momento em que o comando de impressão é executado o os dados a serem impressos são gravados em um arquivo no disco (arquivo spool) liberando rapidamente o programa e quem fica responsavel por direcionar o arquivo spool para a impressora é o próprio SO, que também gerencia a sequencia de impresssão mantendo a eficiencia e a segurança da impressora.

<div>
