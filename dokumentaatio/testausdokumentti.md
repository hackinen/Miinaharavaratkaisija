# Testausdokumentti

Ohjelmaa on testattu automaattitestein JUnitilla sekä ohjelmoinnin aikana manuaalisesti omilla testeillä.

## Automaattitestaus

Olen testannut luokkiani MyBot ja BotLogic sekä tietorakennettani ListOfPairs JUnit-testein, joiden testikattavuus löytyy alla olevista kuvista.

### Testauskattavuus

<img src="https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/misc/testit-MyBot-lopullinen.png" width="750">

<img src="https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/misc/testit-BotLogic-lopullinen.png" width="750">

<img src="https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/misc/testit-ListOfPairs-lopullinen.png" width="750">

## Tehokkuustestaus

Botin tehokkuutta on testattu miinaharavapelissä olevilla kolmella eri kokoisella kentällä (10x10, 16x16 ja 16x30). Tulokset on listattu alla, jokainen koko omassa taulukossaan:

#### 10 x 10

| yritys | päästiinkö läpi | aika (s) |
|:------:|:----------:|:--------|
| 1. | kyllä | 0.0070 |
| 2. | kyllä | 0.0067 |
| 3. | kyllä | 0.0036 |
| 4. | kyllä | 0.0005 |
| 5. | kyllä | 0.0010 |
| 6. | kyllä | 0.0005 |
| 7. | kyllä | 0.0004 |
| 8. | kyllä | 0.0005 |
| 9. | kyllä | 0.0005 |
| 10. | kyllä | 0.0005 |
| avg | | 0.00212|

#### 16 x 16

| yritys | päästiinkö läpi | aika (s) |
|:------:|:----------:|:--------|
| 1. | kyllä | 0.3633 |
| 2. | kyllä | 0.1525 |
| 3. | kyllä | 0.0212 |
| 4. | ei | - |
| 5. | kyllä | 0.0350 |
| 6. | kyllä | 0.0138 |
| 7. | kyllä | 0.0372 |
| 8. | ei | - |
| 9. | kyllä | 0.0292 |
| 10. | kyllä | 1.2057 |
| avg | | 0.2322|

#### 16 x 30

| yritys | päästiinkö läpi | aika (s) |
|:------:|:----------:|:--------|
| 1. | kyllä | 4.6470 |
| 2. | kyllä | 22.8625 |
| 3. | kyllä | 0.0261 |
| 4. | ei | - |
| 5. | kyllä | 0.6233 |
| 6. | ei | - |
| 7. | ei | - |
| 8. | ei | - |
| 9. | ei | - |
| 10. | kyllä | 16.7980 |
| avg | | 8.9914 |


### Tulosten arviointi

Kuten jo näinkin pienellä otoksella havaitaan, peliruudukon koon kasvaessa ja miinoja/ruudukko-suhteen muuttuessa, tulee todennäköisemmäksi se, että botti joutuu arvaamaan jossakin tilanteessa, eikä siis välttämättä saa peliä läpi. Lisäksi isoimmassa ruudukossa välillä odotusaika on _todella_ pitkä, enkä usein ole jaksanut näitä tilanteita odottaa loppuun asti. Käytännössä joka kerta, kun tälläisen (n. 300-600s) pelin olen odottanut loppuun, on jouduttu kuitenkin lopulta arvaamaan ja hävitty. Tästä syystä 16x30-kokoisen ruudukon ajanmittaustulokset saattavat olla hieman vääristyneitä, sillä mittauksissa osui kohdalle yksi pidempi peli, jota en kymmenen minuutin jälkeen enää odottanut loppuun (ts. ei ole tietoa, oltaisiinko tämä peli nyt sitten voitettu vai hävitty).

Näiden kymmenen peliä sisältävien otosten perusteella 10x10-kentässä pelin voittamisen onistumisprosentti oli 100%, 16x16-kentässä 80% ja 16x30-kentässä 50%. Erityisesti viimeisessä kentässä onnistumisprosentti on todennäköisesti todellisuudessa vielä pienempi, sillä kymmenen peliä on vielä kohtuullisen pieni otanta.
