# CalculadoraRMI

Esta é uma aplicação de exemplo onde 2 tipos de clientes(`ClienteA` e `ClienteB`) 
são responsáveis por um valor(`valorX` e `valorY`) guardado no servidor
quando os 2 valores são setados cada cliente fica ciente da soma de ambos valores.

**(Em sistemas baseados em unix trocar o "\\" por "/" e no "-cp" trocar ";" por ":")**
> Não quero fazer duplicatas de script então...

## Compilar
* `javac -d build\classes -sourcepath src -cp ".;exemplormi/*" src/exemplormi/servidor/Servidor.java`
* `javac -d build\classes -sourcepath src -cp ".;exemplormi/*" src/exemplormi/cliente/ClienteA.java`
* `javac -d build\classes -sourcepath src -cp ".;exemplormi/*" src/exemplormi/cliente/ClienteB.java`

## Rodar
* `java -cp build\classes\ exemplormi.servidor.Servidor`
* `java -cp build\classes\ exemplormi.cliente.ClienteA`
* `java -cp build\classes\ exemplormi.cliente.ClienteB`