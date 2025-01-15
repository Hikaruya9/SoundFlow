# SoundFlow - Documentação

## Introdução

O "SoundFlow" é um player de música cujo o foco é permitir com que você toque qualquer música registrada em um determinado Banco de Dados.


## Funcionamento Geral

A ideia é simples: ao utilizar o programa, você poderá criar uma lista de músicas que deseja tocar, de acordo com o que estiver disponível no Banco de Dados.


## Componentes do Player

### Interface Fráfica

**Botões para manipulação de valores do Banco de Dados:** A aplicação possui três botões no lado esquerdo superior.
* **A** está relacionado à tela de adição de música ao Banco de Dados.
* **U** se refere à atualização de uma determinada música do Banco de Dados, conforme o ID buscado.
* **D** traz a tela de remoção de uma determinada música do Banco de Dados, conforme o ID buscado.

**Pesquisa:** O player tem uma barra de pesquisa que será acionada ao pressionar ENTER.

**Listas do player:** O player está separado em duas listas.
* A principal e a que toma maior parte da tela da aplicação é a que retornará a pesquisa do banco de dados.
* A lista da direita e que toma menor parte da tela é destinada à lista sendo tocada naquele momento.

**Controles do Player:** Inclui botões que alteram o estado da música/lista ativa no momento.
* Botão para iniciar/pausar/retomar a música atual.
* Botão para seguir adiante com a próxima música na lista.
* Botão para retornar para a música anterior na lista.
* Botão para realizar um embaralhamento na lista de música atual.
* Botão para ativar um loop na música atual.
* Botão para limpar a lista atual de músicas, parando a reprodução e limpando a lista atual.

### Banco de Dados

**Tabela de música:**
* A tabela onde é salva as músicas adicionadas.


## Etapas do Player

### Inicialização da Aplicação

* Preenche a lista de pesquisa com todas as músicas registradas no Banco de Dados

### Adicionando à lista

* Ao clicar em uma música da lista de pesquisa, ela será adicionada à lista de músicas à ser tocada, podendo até mesmo colocar a mesma música repetidas vezes na lista.

### Iniciando uma música

* Ao clicar duas vezes na lista de músicas atual, ou clicar no botão de play, a música será inicializada.
* Ao finalizar uma música, o player seguirá com a próxima presente na lista automaticamente (caso não esteja com o loop ativado).

### Limpeza de lista

* A partir de um botão na parte superior direira da aplicação você poderá limpar toda a lista atual de músicas e criar uma nova.


## Conclusão

O SoundFlow é um projeto de player simples e um tanto minimalista cuja a ideia é trazer um meio de poder tocar uma 'biblioteca de música' proveniente de um Banco de Dados de forma prática e dinâmica.


## Possíveis implementações ou alterações futuras

* Incluir um meio de alterar o som interno da aplicação, sem a necessidade de ter que alterar o som do sistema ou pelo mixer da aplicação.
* Incluir uma barra de progresso juntamente com o tempo percorrido da música, permitindo com que você possa passar para qualquer trecho da música conforme sua vontade e informando o tempo atual da música.
* Inclusão de um botão para remover apenas uma música selecionada da lista atual, ao invés de ter que remover todas e ter que refazer toda a lista novamente.
* Alinhar a apresentação em texto de ambas as listas (pesquisa e queue), incluindo à lista de pesquisa uma legenda acima da lista que indique o que significa cada coluna.
* Trazer uma forma mais simples de adicionar/atualizar/deleter músicas do Banco de Dados.
