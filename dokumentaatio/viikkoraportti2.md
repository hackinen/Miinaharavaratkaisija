# Viikkoraportti 2

Tällä viikolla aloitin miinaharavapohjan dokumentaatioon, projektin rakenteeseen sekä toimintaan perehtymisellä ja sen kopioimisella oman projektini pohjaksi. Tämän jälkeen aloitin botin koodaamisen.


## Eteneminen

Aloitin projektin toteuttamisen Luomalla pakkaukseen minesweeper.bot luokan MyBot, johon aluksi kopioin metodit luokasta TestBot. Luokkaan MyBot olen tehnyt tällä hetkellä itse metodin makeMove, joka tällä hetkellä osaa ainoastaan merkitä "selkeät" miinat, eli merkitsee lipulla kaikki sellaiset kohdat, jossa numeroa ympäröi tasan itsensä verran avaamattomia ruutuja (jolloin kaikki nämä avamattomat on siis miinoja). Aloitin metodiin myös sen tapauksen luomisen, jossa numeroa ympäröivät miinat on kaikki jo liputettu, jolloin kaikki muut ympäröivät avaamattomat ruudut voidaan avata. En kuitenkaan vielä ehtinyt tehdä tätä toimintoa loppuun asti, joten jatkan siitä seuraavalla viikolla.

Alkuperäisestä suunnitelmasta poiketen on kaikki ohjelmakoodi ja siihen liittyvä dokumentointi (javadoc) englanniksi, sillä projektipohja oli englanniksi, joten olisi tuntunut hassulta kirjoittaa sekaan suomeksi. Koska osa javaprojektista on valmista pohjaa ja osa minun tekemääni, olen yrittänyt javadocissa eritellä nämä kaksi toisistaan. Tällä hetkellä olen vain erikseen maininnut, jos jokin ohjelmakoodissa on minun tekemää, mutta tulevilla viikoilla on tarkoitus kommentoida vielä kaikkeen valmiiseen koodiin, että tämä ei tosiaan ole minun tekemää. Tällä hetkellä projektissa minun tekemääni ohjelmakoodia on luokka BotLogic kokonaan, sekä luokasta MyBot metodi makeMove kokonaisuudessaan.

Testauksessa en ajan puutteen vuoksi ole edennyt vielä ollenkaan, mutta siitä on myös tarkoitus aloittaa  ensimmäisten asioiden joukossa ensi viikolla, jolloin toivon mukaan tälle harjoitustyölle olisi enemmän aikaa käytettävänä.

Tällä viikolla opin gradle-projektin rakenteesta ja 


## Ajankäyttö

Aikaa tähän mennessä tällä viikolla on kulunut 6h.
