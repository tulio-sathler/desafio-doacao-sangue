# Doadores de Sangue

#### Esta aplicação é projetada para auxiliar na busca e gerenciamento de doadores de sangue. Ela fornece várias funcionalidades que permitem salvar informações de pessoas, buscar possíveis doadores por estado, calcular o Índice de Massa Corporal (IMC), buscar percentual de obesos por gênero, calcular a média de idade de doadores por tipo sanguíneo e buscar a quantidade de doadores por tipos sanguíneos.

#### Endpoints da API
A seguir estão os endpoints disponíveis nesta aplicação:

1. Post para salvar pessoas
   ```Endpoint: /api/v1/people/import-all```

#### Descrição: Este endpoint é usado para salvar uma lista de pessoas no formato JSON no banco de dados da aplicação. Caso uma pessoa já esteja no banco de dados, ela será atualizada caso haja alguma alteração nos dados. Caso contrário, uma nova entrada será criada.

2. Busca de possíveis doadores por estado
   ```Endpoint: /api/v1/people/person-by-state```

#### Descrição: Este endpoint permite buscar possíveis doadores de sangue com base no estado em que residem. Ao fazer uma solicitação GET para este endpoint, você receberá uma lista de pessoas que são potenciais doadores de sangue e que residem no estado especificado.

3. Busca do Índice de Massa Corporal (IMC) por faixa etária
   ```Endpoint: /api/v1/imc```

#### Descrição: Este endpoint é usado para buscar o Índice de Massa Corporal (IMC) com base na faixa etária. Ao fazer uma solicitação GET para este endpoint, você receberá informações sobre o IMC médio para cada faixa etária.

4. Busca do percentual de obesos por gênero
   ```Endpoint: /api/v1/imc/weight-by-gender```

#### Descrição: Este endpoint permite buscar o percentual de obesos com base no gênero. Ao fazer uma solicitação GET para este endpoint, você receberá dados sobre o percentual de obesos separados por gênero.

5. Busca da média de idade de doadores por tipo sanguíneo
   ```Endpoint: /api/v1/blood-type/average```

#### Descrição: Este endpoint permite buscar a média de idade dos doadores de sangue com base no tipo sanguíneo. Ao fazer uma solicitação GET para este endpoint, você receberá informações sobre a média de idade dos doadores para cada tipo sanguíneo.

6. Busca da quantidade de doadores por tipos sanguíneos
   ```Endpoint: /api/v1/blood-type/average/donators```

#### Descrição: Este endpoint permite buscar a quantidade de doadores de sangue por tipos sanguíneos. Ao fazer uma solicitação GET para este endpoint, você receberá informações sobre a quantidade de doadores para cada tipo sanguíneo.

Cada endpoint possui uma rota específica e método HTTP associado para acessar as funcionalidades da aplicação. Certifique-se de usar os endpoints corretos e fornecer os parâmetros necessários para obter os resultados desejados.

# DOCUMENTAÇÃO 

Para acessar o banco de dados, acessar a rota: ```http://localhost:8080/h2``` 
Os dados para login estão no application.properties

## As requisições são feitas via postman

A documentação está no arquivo swagger.yaml com descrição dos campos.