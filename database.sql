create table client(
  id int primary key not null,
  nom varchar(50) not null,
  prenom varchar(50) not null
);

create table compte_courant(
  numero int primary key not null,
  client_id int references client(id),
  intitule varchar(50) not null,
  solde decimal(50,2) not null,
  decouvert decimal(10,2)
);

create table compte_epargne(
  numero int primary key not null,
  client_id int references client(id),
  intitule varchar(50) not null,
  solde decimal(50,2) not null,
  taux_interet decimal(3,2)
);

create table operation(
  id int primary key not null,
  montant decimal(50,2) not null,
  id_compte_debite int not null,
  id_compte_credite int not null
);

/*Opérations
Mettre les id des comptes épargnes et des comptes courant en string et non en int.
générer les id avec une suite de chiffre et de lettre aléatoires mais en ayant quelque chose qui permet d'identifier si c'est un compte courant ou un compte épargne.
*/