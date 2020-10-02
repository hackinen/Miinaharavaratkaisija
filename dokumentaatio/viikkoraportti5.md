# Viikkoraportti 5

## Eteneminen

Sain korjattua viime viikon virheet ja ongelmat ja nyt algoritmi toimii (tai ainakin pitäisi toimia, testaus ei ole vielä täysin kattava). Algoritmi on kuitenkin suurimmassa kentässä välillä todella hidas. Hitaus riippuu rekursiossa läpi käytävien reunaruutujen lukumäärästä: jos botti joutuu suorittamaan rekursiivisen päättelyalgoritminsa sellaisessa pelitilanteessa, jossa reunaruutuja on todella paljon, kasvaa laskenta-aikakin huomattavasti. Tämä hitaus oli kuitenkin jo toteutusvaiheessa tiedossa, sillä algoritmi tosiaan käy läpi kaikki mahdolliset vaihtoehdot asettaa lippuja / avata ruutuja ja tämän perusteella päättelee, voiko tarkasteluruudun avata tai liputtaa varmasti.

Lisäksi maininnanarvoista on se, että miinaharava on luonteeltaan sellainen peli, että erityisesti isoissa kentissä tulee vastaan tilanteita, joita ei edes algoritmikaan voi päätellä. Usen siis joko heti alussa tai aivan lopussa päädytään tilanteeseen, jossa bottikin joutuu arvaamaan, sillä yhtäkään siirtoa ei voi päätellä varmaksi. Tähän arvaamiseen toki voisi toteuttaa jonkin todennäköisyyksien mukaan arvaavan toiminnon, mutta en usko, että aika tälläiseen tulee riittämään.

Lisäksi toteutin tällä viikolla tietorakenteen ListOfPairs, jota tullaan käyttämään ArrayListin korvaajana backtracking-algoritmissa.

Ensi viikolla teen oman listarakenteen toteutuksen loppuun sekä sen testauksen ja alan sitten todennäköisesti vielä yrittämään bottivinkkien toteuttamista.

## Testaus

Tällä viikolla tein lisää testejä ja testikattavuus luokissani MyBot ja BotLogic näkyy alla olevasta kuvasta:

<img src="https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/misc/testikattavuus-vko5.png" width="750">

Tietorakenteen ListOfPairs testaamista en vielä aloittanut, sillä ehdin vasta toteuttaa kyseisen luokan, en vielä edes käytä sitä missään.

## Ajankäyttö

Aikaa projektiin on tällä viikolla kului 12h.
