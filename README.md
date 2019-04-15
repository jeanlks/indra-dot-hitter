# Indra Dot Hitter

Esse projeto <b>não tem</b> como objetivo automatizar a marcação de ponto da Indra, uma vez que você precisa informar 
sua senha cada vez que utilizá-lo. O objetivo é apenas facilitar a marcação de ponto, quando você está com pressa de
sair para o almoço ou de correr pro estacionamento onde a fila para a saída já está enorme, sem ter que se preocupar em
logar no sistema, caminhar até a marcação de pontos e enfim bater seu ponto.

## Como utilizar

Clone o projeto e então faça o seguinte:
* Abra a classe **br.com.rk.dot.LoginWorker** e troque o campo *[INSIRA_SUA_MATRICULA_AQUI]* pela sua matrícula da Indra.
* mvn clean package
* navegue até a pasta *target*
* navegue até a pasta *classes*
* **WINDOWS**copie o arquivo *geckodriver.exe* e coloque-o no mesmo diretório do *jar-with-dependencies* gerado no package.
* **LINUX**: copie o arquivo *geckodriver.exe* e coloque-o no mesmo diretório do *jar-with-dependencies* gerado no package.
* *java -jar dot-hitter-1.0-SNAPSHOT-jar-with-dependencies.jar*
* Informe sua senha e clique **ENTRAR**

Ele vai abrir o browser e bater seu ponto automaticamente, mas você precisa informar sua senha sempre que quiser bater
o ponto.

## Considerações

* Não coloque o script para bater seu ponto num horário em que você não está trabalhando.
* Não saia da empresa e deixe o script bater seu ponto depois que você já saiu.
* Seja profissional.