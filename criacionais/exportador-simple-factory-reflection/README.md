## Exportação de lista de Objetos em diferentes formatos

Esta versão do projeto apresentado [anteriormente](https://github.com/JulianCambraia/padroes-de-projeto/tree/main/criacionais/exportador-simple-factory) implementa a exportação de dados de uma lista de qualquer tipo de objetos para formatos
como HTML e MarkDown (extensão .md).

Tal versão utiliza o recurso de [Reflection](https://www.devmedia.com.br/conhecendo-java-reflection/29148) da linguagem Java para descobrir automaticamente os atributos existentes nos objetos da lista a ser
exportada. Assim, tais atributos se tranformam nas colunas da tabela gerada no formato escolhido.

Esta é uma implementação mais flexível e realista, pois permite exportar qualquer tipo de lista.