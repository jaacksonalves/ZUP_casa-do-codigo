# ZUP_casa-do-codigo
Desafio BootCamp Orange Talents Zup


Casa do código
0-0-0-setup
Nessa tarefa precisamos criar um projeto para atender as funcionalidades da Casa do código, para tal, temos alguns pré requisitos de linguagem de programação e tecnologia, pois precisamos que esse projeto seja evoluído e mantido por anos, portanto é extremamente importante a escolha das mesmas.

Utilizar o Spring Initializr

0-0-2-cadastro-novo-autor
necessidades
É necessário cadastrar um novo autor no sistema. Todo autor tem um nome, email e uma descrição. Também queremos saber o instante exato que ele foi registrado.
restrições
O instante não pode ser nulo
O email é obrigatório
O email tem que ter formato válido
O nome é obrigatório
A descrição é obrigatória e não pode passar de 400 caracteres
resultado esperado
Um novo autor criado e status 200 retornado
0-0-3-email-autor-unico
necessidades
O email do autor precisa ser único no sistema
resultado esperado
Erro de validação no caso de email duplicado
0-0-4-cadastro-de-uma-categoria
necessidades
Toda categoria precisa de um nome
restrições
O nome é obrigatório
O nome não pode ser duplicado
resultado esperado
Uma nova categoria cadastrada no sistema e status 200 retorno
Caso alguma restrição não seja atendida, retorne 400 e um json informando os problemas de validação
0-0-4.1-criacao-validador-generico
necessidades
Tanto para o cadastro do autor quanto para o cadastro da categoria, foi necessário realizar uma validação de valor único no sistema. Neste caso, só muda um detalhe da query que estamos executando para fazer a verificação. E agora, será que você consegue criar seu validador customizado para reutilizá-lo nas validações de email de autor e nome de categoria?

0-0-5-criar-um-novo-livro
necessidades
Um título
Um resumo do que vai ser encontrado no livro
Um sumário de tamanho livre. O texto deve entrar no formato markdown, que é uma string. Dessa forma ele pode ser formatado depois da maneira apropriada.
Preço do livro
Número de páginas
Isbn(identificador do livro)
Data que ele deve entrar no ar(de publicação)
Um livro pertence a uma categoria
Um livro é de um autor
restrições
Título é obrigatório
Título é único
Resumo é obrigatório e tem no máximo 500 caracteres
Sumário é de tamanho livre.
Preço é obrigatório e o mínimo é de 20
Número de páginas é obrigatória e o mínimo é de 100
Isbn é obrigatório, formato livre
Isbn é único
Data que vai entrar no ar precisa ser no futuro
A categoria não pode ser nula
O autor não pode ser nulo
resultado esperado
Um novo livro precisa ser criado e status 200 retornado
Caso alguma restrição não seja atendida, retorne 400 e um json informando os problemas de validação
0-0-6-exibir-lista-livros
necessidade
Para que seja fácil pegar um id do livro, vamos exibir a lista de livros cadastrados.

resultado esperado
um json com a lista de livros com id e nome do livro

0-0-7-pagina-detalhe-livro
Implementação da página de detalhe
Precisamos criar uma página com as mesmas informações que encontramos na página de detalhe da Casa do Código. Aqui está a página real => https://www.casadocodigo.com.br/products/livro-spring-boot

A ideia aqui é implementar todo código necessário para que tenhamos uma página com quase todas informações da página de detalhe da CDC.

necessidades
Ter um endpoint que em função de um id de livro retorne os detalhes necessários para montar a página.
restrições
Se o id não existir é para retornar 404
Resultado esperado
que o front possa montar a página
0-0-8-cadastro-de-pais-e-estados-do-pais
necessidades
Precisamos de um cadastro simples de países e seus respectivos estados.

Cada país tem um nome e cada estado tem um nome e pertence a um país.

restrições para país
o nome é obrigatório
o nome é único
restrição para estados
o nome é obrigatório
o nome é único para o mesmo país
o país é obrigatório
resultado esperado
Dois endpoints para que seja possível cadastrar países e estados. Pode existir país sem estados associados.
Caso alguma restrição não seja atendida, retornar 400 e json com os problemas de validação.
0-0-9-comeco-fluxo-pagameno-parte-1
necessidades
Agora vamos começar o processo de conclusão de compra. Primeiro vamos realizar um cadastro de clientes.

Os seguintes campos precisam ser preenchidos:

email
nome
sobrenome
documento(cpf/cnpj)
endereco
complemento
cidade
pais
estado(caso aquele pais tenha estado)
telefone
cep
restrição
email obrigatório e com formato adequado
email é único no sistema
nome obrigatório
sobrenome obrigatório
documento(cpf/cnpj) obrigatório e só precisa ser um cpf ou cnpj
documento é único no sistema
endereco obrigatório
complemento obrigatório
cidade obrigatório
país obrigatório
se o país tiver estados, um estado precisa ser selecionado
estado(caso aquele pais tenha estado) - apenas se o país tiver cadastro de estados
telefone obrigatório
cep é obrigatório
resultado esperado
Cliente cadastrado no sistema e status 200 retornado com o id do novo cliente como corpo da resposta.
