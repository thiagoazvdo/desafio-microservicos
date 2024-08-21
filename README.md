# desafio-ntconsult
Sistema de reserva de hotéis escalável. 

Sobre o desafio:

Requisitos >

1.Pesquisa de Hoteis: Os usuários devem poder pesquisar hoteis com base em critérios como destino, datas de check-in e check-out, número de quartos e número de hóspedes.

2.Comparação de Opções: Os usuários devem poder comparar diferentes opções de hoteis com base em critérios como preço, localização, comodidades e avaliações de outros usuários.

3.Reserva de Quartos: Os usuários devem poder selecionar um hotel e reservar quartos para as datas desejadas, inserindo informações como nome, contato e detalhes do pagamento.

4.Sistema de Notificações: Utilize um sistema de notificações para confirmar o processamento check-in/check-out com o seu devido status de confirmação da reserva.


Critérios de Avaliação > 

1.Implementação completa e precisa dos requisitos funcionais e técnicos, junto de sua modelagem e diagrama.

2.Eficiência e escalabilidade do sistema no gerenciamento de um grande volume de hoteis, reservas e notificações.

3.Garantia da entrega confiável de notificações, mesmo em caso de falhas temporárias no sistema.

4.Persistência correta dos dados, justifique o motivo da escolha do banco de dados.

5.Implemente uma estratégia abrangente de logs e métricas para monitorar o desempenho e a saúde do sistema em tempo real.


Avaliação >

1.Testes feitos

2.Ideias que gostaria de implementar se tivesse mais tempo

3.Decisões que forem tomadas e seus motivos como arquiteturas que forem testadas, os motivos de terem sido modificadas, instruções de deploy e instalação, etc..

4.Se possível, um design system da proposta

5.Bom uso do design SOLID

6.Uso de princípios Cloud Native como 12 Factor aplicados a solução


------------------------------------------------------------------------------------------------------------------

Inicio do desenvolvimento.

A escolha da arquitetura de microservicos visa dividir o sistema em componentes menores para torná-lo(s) escaláveis caso necessario. 
Outro ponto preponderante na escolha da abordagem de microservicos foi a questao do isolamento, bastante util em cenarios complexos, mantendo o funcionamento dos demais servicos, aumentando a disponibilidade e facilitando a manutencao e atualizacao do código.

A complexidade do desafio aliada a uma variedade enorme de possiblidades de desenvolvimento acabaram me fazendo perder mais tempo que o necessário para o início do desenvolvimento.

A maneira pensada inicialmente foi a seguinte: o usuário tem acesso os microserviços de busca de hotéis, comparação e reservas, ao passo que ao realizar uma reserva a mesma é persistida no banco do microserviço e através de mensageria com RabbitMQ é enviada uma mensagem com os dados da reserva ao serviço de notificações (este, posteriormente pode enviar mensagem aos clientes, e aos demais serviço a depender da necessidade de cada um). 

![image](https://github.com/user-attachments/assets/4f683c35-85bf-4f02-ae78-f16d570d9309)

Próximos passos:

>Fechar o escopo e definir com mais clareza os requisitos de cada microserviço;

>Implementar uma ferramenta de monitoramento de logs como o SLF4J;

>Implementar segurança com o Keylock para gerenciamento identidade e acesso;

>Desenvolver testes unitários para cada microserviço;

>Conteinerizar a aplição (individualmente com dockerfiles e o todo com docker-compose);

