# Viikkoraportti 3

## Eteneminen

Tällä viikolla huomattava osa ajasta kului checkstylen ja javadocin saattamiseen osaksi projektia, sillä gradlen kanssa tässä oli hieman ongelmia. Ongelmat kuitenkin ratkesivat ja nyt projektissa on käytössä checkstyle, javadoc sekä jacoco. Muuten tällä viikolla olen refaktoroinut ja korjannut koodiani, koodannut lisää, tehnyt testejä sekä dokumentaatiota. Tämänhetkinen testikattavuus on näkyvissä [testausdokumentissa](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/testausdokumentti.md). Testejä ei ole vielä montaa, ja niitäkin tulen vielä parantelemaan ja tekemään lisää jatkossa.

Ohjelma on tällä viikolla edennyt niin, että nyt botti osaa helppojen lippujen laittamisen lisäksi avata kaikki avaamattomat ruudut jonkin jo avatun (eli numeroidun) ruudun ympäriltä, mikäli sitä ympäröiviin ruutuihin on merkitty oikea määrä lippuja. Tähänastisessa muodossaan botti selviää jo varsin pitkälle hyvän pelilaudan osuessa kohdalle: pienimmässä kentässä botti saa jo pelin voitettuakin hyvällä tuurilla. Tämän jälkeen toteutettavat päättelyt ovatkin sitten haastavampia ja niissä tullaan todennäköisesti tarvitsemaan jonkinsorttista rekursiota. Ensi viikolla onkin tarkoitus alkaa pähkäilemään näitä hankalampia päättelyjä ja/tai alkaa toteuttamaan myös pelkkiä vinkkejä antavaa osuutta botista.

Epäselvältä tällä hetkellä tuntuu ensi viikon eteneminen, että millähän tavalla niitä hankalampia päättelyitä tulisi lähteä ratkomaan. Hankalampiin peliliikkeisiin ei enää riitä pelkkä yhden 3x3-alueen tarkastelu, vaan on tarkasteltava suurempaa aluetta / useampia 3x3-alueita. En tähän mennessä ole vielä keksinyt muuta tapaa kuin tarkastella jokaisen tietyn tyyppisen päättelyketjun omana kohtanaan makeMove-metodissa MyBot-luokassa (ja näitä metodin vaiheita erittelisin sitten omiin metodeihinsa).

Tällä hetkellä projektissa minun tekemiä osa-alueita ovat minesweeper.bot-pakkauksessa MyBot-luokan metodi makeMove, BotLogic-luokka sekä testeistä testiluokat BotLogicTest ja MyBotTest.

## Ajankäyttö

Aikaa tällä viikolla kului 15h.
