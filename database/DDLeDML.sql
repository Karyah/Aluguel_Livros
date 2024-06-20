create database aluga_livro;
use aluga_livro;

create table usuario ( 
id int not null auto_increment,
nome varchar(70) not null, 
senha varchar(30) not null,
login varchar(15) not null,
email varchar(100) not null,
cpf varchar(11) not null,
ativo bool not null,
primary key(id)
);

create table livro (
id int not null auto_increment,
titulo varchar(50) not null,
autor varchar(30) not null,
url_imagem varchar(200) not null,
sinopse varchar(400) not null,
genero varchar(20) not null,
disponivel bool not null, 
primary key (id)
);


alter table livro rename column id to id_livro;
alter table usuario rename column id to id_usuario;
alter table usuario modify column senha varchar(100);


insert into livro (id_livro, url_imagem, titulo, autor, sinopse, genero, disponivel) values 
(1, "https://m.media-amazon.com/images/I/71LJ4k-k9hL._SY425_.jpg", "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Nesta história que marcou gerações de leitores em todo o mundo, um piloto cai com seu avião no deserto do Saara e encontra um pequeno príncipe, que o leva a uma aventura filosófica e poética através de planetas que encerram a solidão humana. O pequeno príncipe é uma obra atemporal, com metáforas pertinentes e aprendizados sobre afeto, sonhos, esperança e tudo aquilo que é invisível aos olhos.", "Infantil", 1),

(2, "https://m.media-amazon.com/images/I/410TKbO3pSL._SY445_SX342_.jpg","Dom Quixote", "Miguel de Cervantes", " A história gira em torno de Alonso Quijano, um fidalgo empobrecido que decide se tornar um cavaleiro errante e defender os oprimidos. Vestido com uma armadura antiga, dá a si mesmo o nome de Dom Quixote e parte em busca de aventuras acompanhado por seu leal escudeiro, Sancho Pança.", "Aventura", 1),

(3, "https://m.media-amazon.com/images/I/817esPahlrL._SY425_.jpg", "Cem Anos de Solidão", "Gabriel García Márquez", "Neste clássico de Gabriel García Marques, conheça as fabulosas aventuras dos Buendía-Iguarán, com seus milagres, fantasias e dramas que representam famílias do mundo inteiro. Romance fundamental na história da literatura, Cem anos de solidão apresenta uma das mais fascinantes aventuras literárias do século XX.", "Ficcao", 1),

(4, "https://m.media-amazon.com/images/I/911dPGW1jrL._SY385_.jpg", "Eragon", "Christopher Paolini", "Quando Eragon encontra na floresta uma pedra azul polida, acredita que poderá ser uma descoberta de sorte para um simples rapaz do campo: talvez sirva para comprar carne que alimentará a família durante o inverno. Mas, no momento em que um dragão nasce de dentro da pedra, Eragon percebe que está diante de um legado quase tão antigo quanto o do próprio Império.", "Fantasia", 1),

(5, "https://m.media-amazon.com/images/I/41897yAI4LL._SY445_SX342_.jpg", "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Harry Potter é um garoto cujos pais, feiticeiros, foram assassinados por um poderosíssimo bruxo quando ele ainda era um bebê. Ele foi levado, então, para a casa dos tios que nada tinham a ver com o sobrenatural. O menino de olhos verde e desengonçado, tão habituado à rejeição, descobre, também, que é um herói no universo dos magos.", "Fantasia", 1),

(6, "https://m.media-amazon.com/images/I/41+PZUZS7LL._SY445_SX342_.jpg", "O Diário de Anne Frank", "Anne Frank", "O Diário de Anne Frank teve a autenticidade confirmada por peritos. Estudos forenses da caligrafia de Anne e exame do papel do diário, da tinta e da cola comprovaram ser de material existente na época. A conclusão foi oficialmente apresentada pelo Instituto Estatal Holandês para Documentação da Guerra.", "Biografia", 1),

(7, "https://m.media-amazon.com/images/I/51wdOrz6uNL._SY445_SX342_.jpg","O sol é para todos", "Harper Lee", "A história de uma jovem que cresce no sul dos Estados Unidos durante a década de 1930 e aprende sobre racismo e injustiça.", "Ficcao", 1),

(8, "https://m.media-amazon.com/images/I/819js3EQwbL._SY425_.jpg","1984", "George Orwell", "Winston, herói de 1984, último romance de George Orwell, vive aprisionado na engrenagem totalitária de uma sociedade completamente dominada pelo Estado, onde tudo é feito coletivamente, mas cada qual vive sozinho. Ninguém escapa à vigilância do Grande Irmão, a mais famosa personificação literária de um poder cínico e cruel ao infinito, além de vazio de sentido histórico.", "Ficcao", 1),

(9, "https://m.media-amazon.com/images/I/71u9uqTYBcL._SY385_.jpg","E não sobrou nenhum", "Agatha Christie", "Uma ilha misteriosa, um poema infantil, dez soldadinhos de porcelana e muito suspense são os ingredientes com que Agatha Christie constrói seu romance mais importante. Na ilha do Soldado, antiga propriedade de um milionário norte-americano, dez pessoas sem nenhuma ligação aparente são confrontadas por uma voz misteriosa com fatos marcantes de seus passados.", "Misterio", 1),

(10, "https://m.media-amazon.com/images/I/71Xta4Nf7uL._SY385_.jpg","Orgulho e Preconceito", "Jane Austen", "Orgulho e Preconceito é um dos mais aclamados romances da escritora inglesa Jane Austen. Publicado em 1813, revela como era a sociedade da época, quando os relacionamentos se desenrolavam de maneira mais lenta e romântica, no ritmo das cartas levadas por mensageiros a cavalo. Nesse mundo, o sonho da Sra. Bennet era casar bem suas cinco filhas: Jane, Elizabeth, Mary, Kitty e Lydia.", "Romance", 1),

(11, "https://m.media-amazon.com/images/I/41aVasi7pML._SY445_SX342_.jpg","O Código Da Vinci", "Dan Brown", "Um assassinato no Museu do Louvre traz à tona uma sinistra conspiração para revelar um segredo que foi protegido por uma sociedade secreta desde os tempos de Jesus Cristo. A vítima é o curador do museu, Jacques Saunière, um dos líderes dessa fraternidade, o Priorado de Sião, que já teve como membros Leonardo da Vinci, Victor Hugo e Isaac Newton.", "Misterio", 1),

(12, "https://m.media-amazon.com/images/I/A1ajQ9OHOIL._SY385_.jpg","A Garota no Trem", "Paula Hawkins", "Rachel Watson é uma mulher divorciada e alcoólatra que todos os dias pega o trem e observa um casal em uma casa próxima à linha férrea. Um dia, ela testemunha algo que a choca e decide se envolver na investigação do desaparecimento da mulher que ela observava.", "Misterio", 1),

(13, "https://m.media-amazon.com/images/I/81iqH8dpjuL._SY385_.jpg", "A biblioteca da Meia-Noite", "Matt Haig", "Nora Seed é uma mulher cheia de talentos e poucas conquistas. Arrependida das escolhas que fez no passado, ela vive se perguntando o que poderia ter acontecido caso tivesse vivido de maneira diferente. Após ser demitida e seu gato ser atropelado, Nora vê pouco sentido em sua existência e decide colocar um ponto final em tudo.", "Romance", 1),

(14, "https://m.media-amazon.com/images/I/41pbZcXFYkL._SY445_SX342_.jpg","Jogos Vorazes", "Suzanne Collins", "Na abertura dos Jogos Vorazes, a organização não recolhe os corpos dos combatentes caídos e dá tiros de canhão até o final. Cada tiro, um morto. Onze tiros no primeiro dia. Treze jovens restaram, entre eles, Katniss. Para quem os tiros de canhão serão no dia seguinte?...", "Ficcao", 1),

(15, "https://m.media-amazon.com/images/I/81rSPlvS0hL._SY425_.jpg", "Divergente", "Veronica Roth", "Uma escolha pode te transformar. Nesta versão futurista da cidade de Chicago, a sociedade se divide em cinco facções dedicadas ao cultivo de uma virtude – a Abnegação, a Amizade, a Audácia, a Franqueza e a Erudição. Aos dezesseis anos, numa grande cerimônia de iniciação, os jovens são submetidos a um teste de aptidão e devem escolher a que grupo querem se unir para passar o resto de suas vidas.", "Ficcao", 1);
