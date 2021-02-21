# Padrões de Projeto Comportamentais

### 1. Strategy (Estratégia)

### 1.1. Definição

"O padrão Strategy define uma família de algorítmos, encapsula cada um deles em os torna intercambiáveis.
A estratégia deixa o algorítmo variar independentemente dos clientes que o utilizam."

Em outras palavras, a partir de um conjunto de algorítmos, permite que classes possam trocar tais algorítmos por uma
outra implementação, até mesmo em tempo de execução.


### 1.2. Aplicabilidade

Pode ser aplicado quando:

* o comportamento de um método (implementação de um algorítmo) precisa ser diferente em classes distintas e/ou mudar em tempo de 
execução;

* determinadas classes devem ter um comportametno específico (método) e outras não;

* não deseja-se que uma alteração em uma super classe afete sub classes.

### 1.3. Modelagem do Padrão

![alt text](https://github.com/juliancambraia/padroes-de-projeto/blob/main/imagens/strategy-base-class-diagram.png?raw=true)

A classe ``Estrategista`` é que irá usar as estratégias, que são representadas pelas classes que implementam os comportamentos.
Cada comportamento (estratégia) é normalmente definido como uma interface. Assim, podem existir N implementações de cada
comportamento (diferentes estratégias)

Perceba que a relação entre a ``Estrategista`` e os comportamentos não é hereança, mas pode ser uma associação normal, composição
ou agregação. Cada comportamento não é implementado como uma subclasse da ``Estrategista``, cada tipo de comportamento estará contido
como um atributo dentro da ``Estrategista``. Por isso é comum representar como agregação/composição. Definindo o comportamento como
atributo é que nos permite alterar em tempo de execução sua implementação.

O comportamento em si é definido por um método de interface. No exemplo, o método é ``executarComportamentoA()`` para o ``ComportamentoA()``.
O nome do método é o desenvolvedor que define, normalmente sendo um nome que faça sentido para o sistema. A assinatura do método também é livre.
Neste exemplo o método não recebe parâmetros e retorna um tipo genérico ``T``. O tipo de retorno vai depender das suas necessidades.
Veja os exemplos concretos na seção a seguir.

Podem existir diferentes classes filhas desta ``Estrategista``, cada uma fazendo uso diferente do resultado de um determinado comportamento.
Com o padrão Strategy, o comportamento de qualquer classe (mãe ou filha) pode mudar em tempo de execução, de acordo com os requisitos do sistema.