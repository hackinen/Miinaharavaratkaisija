# Viikkoraportti

## Eteneminen

Tällä viikolla korjailin muutamia virheitä listarakenteessa ListOfPairs sekä tein tälle luokalle testit. Korvasin algoritmista ArrayList-rakenteen tällä omalla ListOfPairs-rakenteellani, sekä toteutin vinkkejä antavan toiminnallisuuden bottiin. Päädyin (ainakin nyt) sellaiseen ratkaisuun, että botti antaa vain yhden vinkin kerrallaan. En ole aivan varma, tulisiko minun muokata Bot-rajapinnassa määritelty metodi getPossibleMoves palauttamaan oman listaolioni ArrayListin sijasta, sillä tällöin minun tulee muokata myös valmista miinaharavapohjaa monesta kohtaa. Toki siis tällä hetkellä en kyseisessä metodissa koko listaa tarvitsisi, sillä palautan listan mukana vain yhden siirron.

Lisäksi parantelin dokumentaatiota ja tein tehokkuustestausta eri kokoisilla miinaharavakentillä. Loppupalautusta varten vielä jää ohjelmakoodin refaktoroimista ja siistimistä, tehokkuustestausta ja muuta dokumentointia, loput testit sekä mahdollisesti vinkkejä antavan toiminnallisuuden muuttaminen listamuotoon. Viimeisestä en ole vielä ihan varma, että toteutanko sen vai en, sillä mielestäni yksi vinkki on riittävä.

### Testit

Tämänhetkinen testikattavuus sekä tehokkuustestaus löytyvät molemmat [testausdokumentista](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/testausdokumentti.md).

## Ajankäyttö

Aikaa projektin parissa tällä viikolla kului 10h.
