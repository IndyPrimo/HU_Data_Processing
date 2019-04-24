-- S1: DDL Statements - inleveropdracht
-- Opdracht 1:
alter table s1_medewerkers add geslacht varchar(1) constraint ck_geslacht check (geslacht = 'M' OR geslacht = 'V');

-- Opdracht 2:
create sequence afdelingsnummers start with 50 increment by 10;

-- Opdracht 3:
create table s1_hisadres(
    postcode char(6) not null check (postcode like '^[[:digit:]]{4}[[:upper:]]{2}$'),
    huisnummer number,
    ingangsdatum date not null,
    einddatum date,
    telefoon number(10) unique,
    med_mnr number not null,
    constraint date_check check(einddatum > ingangsdatum),
    constraint hisadres_pk primary key (postcode, huisnummer, ingangsdatum),
    constraint med_mnr_fk foreign key (med_mnr) references s1_medewerkers("MNR")
    );

    
-- Opdracht 4:
constraint M_VERK_CHK check (LNNVL(functie = 'VERKOPER') = LNNVL(comm IS NOT NULL))