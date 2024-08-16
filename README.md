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

A escolha da arquitetura de microservicos visa dividir o sistema em componentes menores para torna-lo(s) escalavel apenas se necessario. 
Outro ponto que prevaleceu na escolha da abordagem de microservicos foi a questao do isolamento, bastante util em cenarios complexos, mantendo o funcionamento dos demais servicos, aumentando a disponibilidade e facilitando a manutencao e atualizacao.

Diagrama ER Microserviço de Hotéis (pendente):

<img width="576" alt="Captura de Tela 2024-08-15 às 18 32 17" src="https://github.com/user-attachments/assets/12f113a9-ac91-4ff6-a60c-ae348f1c1cbc">

Diagrama ER Microserviço de Reservas (pendente):

![image](https://github.com/user-attachments/assets/61b133be-5f73-4da4-9295-b1f1194c50f8)

Diagrama inicial Microserviço de Notificacao (pendente):

![image](https://github.com/user-attachments/assets/bd6eed58-69f5-41b3-b945-64364dbd7131)


Diagrama do Microserviço de Comparacoes de Hotéis (pendente).

...
A ideia seria implementar todos os microservicos com tratamento de excecao, testes, funcionalidades descritas no requisitos validadas, e fazer o deploy em containers docker. De toda forma gostei bastante do desafio proposto e pretendo desenvolver o restando independente do resultado. Desde ja agradeco o tempo e a oportunidade e me coloco a diposicao. 

