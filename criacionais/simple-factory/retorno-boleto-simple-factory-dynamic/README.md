## Leitura Dinâmica de Retorno de Boletos Bancários usando Template Method e Simple Factory

Esta versão do projeto implementa a leitura de retorno de boletos com o padrão Strategy e Template Method, evitando a duplicação de código
existente na versão anterior utilizando apenas o padrão Strategy.

Por estar utilizando os dois padrões em conjunto, note que a estrutura das clases não refletem exatamente os diagramas em anexo

Esta é uma versão alternativa do projeto [retorno-boleto-simple-factory](https://github.com/JulianCambraia/padroes-de-projeto/tree/main/criacionais/simple-factory/retorno-boleto-simple-factory)
que não utiliza programação funcional e evita o uso de blocos de `if` para selecionar qual classe instanciar. Ela utiliza carregamento dinâmico de classes utilizando o método `Class.forName()`, 
descobrindo automaticamente qual o nome da classe que deve ler um arquivo de um determinado banco. Se a classe existir, ela será carregada. Com esta implementação a Simple Factory é totalmente aderente ao 
Open/Close Principle (OCP)