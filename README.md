# GameOfLife
Naprogramujte simulaci života navrženou před více než 50 lety britským matematikem J.H. Conwayem. Funguje na dvourozměrné ploše, v originále nekonečné, nám prozatím postačí vhodně zvolená velikost mezi 10x10 a 40x20, aby se rozumně vešla na obrazovku konzole. Pokud možno velikost PARAMETRIZUJTE, aby změna velikosti plochy nevyžadovala více zásahů do programu.
Každý prvek plochy tohoto gridu reprezentuje buňku, která může být buď živá nebo mrtvá, existující/neexistující. Každá taková buňka má až osm sousedů (jejichž vzdálenost v osách x a y je nejvýše 1). Simulace spočívá v provádění jednotlivých kroků, kdy pro všechny buňky najednou se rozhodne, zda budou v následujícím kroku živé či mrtvé podle těchto pravidel:
1) Má-li živá buňka méně než dva sousedy nebo více než tři sousedy, uhyne (nedostatek kontaktu nebo naopak přemnožení)
2) Má-li živá buňka dva nebo tři sousedy, přežije do následující generace/kroku.
3) Mrtvá buňka (prázdné pole) s *právě třemi* sousedy dá na tomto místě vzniknout živé buňce (množení).
Podle počátečního vstupu (první generace) se Život může vyvíjet zcela různými směry. Pro začátek můžete vyjít z nějaké pevně dané (nebo zcela náhodné) vstupní kombinace a umět postupně provádět (a zobrazovat) jednotlivé kroky.
Bylo by fajn, pokud by vaše aplikace uměla poznat "zacyklení", tj. že už se zmíněná kombinace v některém z předchozích kroků objevila. Můžete se omezit na vhodně zvolený počet posledních kroků (např. 11).

TIP: pro vyhodnocení je jednodušší, když nemusíte "řešit" okraje a podmínky, čehož dosáhnete tím, že si vytvoříte pole s okrajem navíc (na všech stranách), takže každá buňka bude mít všech osm sousedů. Ale samotné vyhodnocení, tj. rozhodování, jestli v dalším kroku buňka bude či ne, provádějte jen na původních rozměrech.
