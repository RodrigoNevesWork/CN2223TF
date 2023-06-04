# CN2223TF - Sistema de Processamento de Imagens em Nuvem

## Descrição do Projeto
CN2223TF é um sistema desenvolvido com o objetivo de processar imagens para identificar a existência de monumentos ou locais famosos (landmarks). O sistema utiliza serviços da Google Cloud Platform para armazenamento, comunicação e computação, e possui capacidade de adaptação a variações de carga, ou seja, ele é elástico e pode aumentar ou diminuir sua capacidade de processamento de imagens em simultâneo.

## Objetivos
- Desenvolver um sistema para submissão e execução de tarefas de computação na nuvem.
- Utilizar serviços integrados da Google Cloud Platform, incluindo Cloud Storage, Firestore, Pub/Sub, Compute Engine, Cloud Functions, Vision API e Static Maps API.
- Processar imagens para verificar a existência de monumentos ou locais famosos.
- Identificar o local da imagem e obter uma imagem correspondente a um mapa da zona do monumento identificado.
- Implementar a elasticidade do sistema para ajustar a capacidade de processamento de imagens em tempo real.

## Requisitos do Sistema
- Conta na Google Cloud Platform com acesso aos serviços necessários.
- Java 11 instalado.
- Maven instalado.

## Configuração
1. Clone o repositório do projeto: `git clone https://github.com/seu-usuario/cn2223tf.git`
2. Acesse o diretório do projeto: `cd cn2223tf`
3. Compile o projeto e empacote as dependências: `mvn clean package`
4. Configure as credenciais da Google Cloud Platform:
   - Faça o download das credenciais do serviço na GCP (arquivo JSON).
   - Renomeie o arquivo para `credentials.json`.
   - Mova o arquivo para o diretório `src/main/resources/`.
5. Realize as configurações adicionais necessárias nos arquivos de configuração (`src/main/resources/application.properties`).

## Uso
1. Execute o sistema: `java -jar target/cn2223tf.jar`
2. Siga as instruções fornecidas no terminal para submeter tarefas de processamento de imagens.
3. Acompanhe o progresso das tarefas e visualize os resultados no terminal.
