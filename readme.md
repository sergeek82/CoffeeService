 # **_Требования задачи._**
 
### В системе существует много микросервисов, обслуживающие интересы кофейной корпорации. Ваша задача разработать один микросервис.

>* Данный микросервис принимает сообщения через брокера сообщений Kafka о новом поступлении зерна, мешок зерна весит 60кг и имеет страну происхождения, % робусты и % арабики, а так же сорт зерна.
>* По gRPC вам отправляют информацию об обжарке поступившего зерна, а именно какое количество взяли сорта и из какой страны происхождения, вес на выходе и номер бригады.
>* По REST сервис должен отдавать информацию о количестве остатков по каждому сорту и стране с возможностью фильтровать запросы на стороне СУБД, информацию о бригадах какой у них % потери при обжарке, % потерь по каждой стране происхождения.
>* Так же следует описать swagger и протестировать основные механизмы с помощью unit тестирования.
>* Идентификатор бригады UUID, получаемые сообщения являются истиной, СУБД кроме H2, реализовывать другие сервисы не нужно, минимальная величина измерения граммы, вид сообщения в kafka – pojo.