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