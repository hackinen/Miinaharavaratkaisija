# Toteutusdokumentti

## Projektin rakenne

Miinaharavaratkaisija on toteutettu osaksi valmista [miinaharavapohjaa](https://github.com/TiraLabra/minesweeper). Projekti on toteutettu pakkauksen minesweeper.bot alle, missä omaa ohjelmakoodiani ovat luokat MyBot ja BotLogic. MyBot-luokassa siirtoja ehdottava toiminto ei ole vielä toiminnassa, joten se on vielä toistaiseksi valmiista pohjasta kopioitu satunnaistoiminto. Lisäksi oma listarakenne tullaan toteuttamaan oman pakkauksensa minesweeper.datastructures alle.


## Tilanteet, joissa on pakko arvata

Maininnanarvoista on tosiaan se, että miinaharava on luonteeltaan sellainen peli, että erityisesti isoissa kentissä tulee vastaan tilanteita, joita ei edes algoritmikaan voi päätellä. Usen siis joko heti alussa tai aivan lopussa päädytään tilanteeseen, jossa bottikin joutuu arvaamaan, sillä yhtäkään siirtoa ei voi päätellä varmaksi.
