## Exportação de lista de produtos em diferentes formatos

Este é um projeto que implementa a exportação de dados de uma lista de produtos para formatos como HTML e Markdown (extensão .md).
Ela é uma versão introdutória bastante limitada, pois só trabalha com lista de produtos. Para exportar uma lista de outro tipo de objeto,
seria necessário implementar novas clases, não sendo uma solução viável.


![alt text](https://github.com/juliancambraia/padroes-de-projeto/blob/main/imagens/exportador-simple-factory.png?raw=true)
Figure 1. Diagrama de classes para implementação do exportador de lista de produtos para HTML e Markdown.

| Código| Descrição| Valor
| -----| -----| -----
| 1| TV| 1000.0
| 2| Geladeira| 900.0
| 3| Notebook| 3200.0

<table>
<tr><td>Código</td><td>Descrição</td><td>Valor</td></tr>
<tr><td>1</td><td>TV</td><td>1000.0</td></tr>
<tr><td>2</td><td>Geladeira</td><td>900.0</td></tr>
<tr><td>3</td><td>Notebook</td><td>3200.0</td></tr>
</table>