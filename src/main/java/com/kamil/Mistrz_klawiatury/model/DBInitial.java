package com.kamil.Mistrz_klawiatury.model;

import com.kamil.Mistrz_klawiatury.repository.TextsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBInitial implements CommandLineRunner {
    @Autowired
    private TextsRepository textsRepository;

    @Override
    public void run(String... args){
        insertIntoDatabase("Akademia Pana Kleksa", "Do niezwykłej szkoły - Akademii pana Kleksa - mieszczącej się przy ulicy Czekoladowej, trafia Adaś Niezgódka, chłopiec którego prześladuje pech. W szkole jednak okazuje się niezwykle zdolny i w krótkim czasie zostaje ulubieńcem profesora - uczestniczy w przygotowaniu potraw z kolorowych szkiełek, przygląda się leczeniu chorych sprzętów, udaje mu się nawet, wzorem pana Kleksa, unieść się w powietrze i dolecieć do psiego raju. Adaś jest także powiernikiem szpaka Mateusza, który jest wielkim przyjacielem profesora. Mateusz opowiada chłopcu o swojej przeszłości - był księciem, ale zabił króla wilków i za karę wilki spustoszyły jego kraj, a on sam zamienił się w ptaka dzięki cudownej czapce bogdychanów.");
        insertIntoDatabase("Biały kieł", "Biały Kieł jest dzieckiem Kiche, pół psa, pół wilczycy, i wilka Jednookiego. Przychodzi na świat w lesie, dokąd uciekła jego matka, gdy jej ludzki właściciel nie miał czym jej karmić, i tam przyłączyła się do stada wilków. Matka opiekuje się Białym Kłem troskliwie, uczy go polowania, pokazuje, co jest niebezpieczne, a czego nie trzeba się bać. Pewnego dnia Biały Kieł spotyka w lesie ludzi. Okazuje się, że jednym z nich jest Szary Bóbr, pan Kiche, i tym sposobem szczeniak wraz z matką trafiają do ludzkiej wioski.");
        insertIntoDatabase("Chatka puchatka", "Chatka Puchatka to zbiór krótkich, zabawnych historyjek o zwierzętach - mieszkańcach Stumilowego Lasu i ich przyjacielu, małym chłopcu o imieniu Krzyś. Bohaterowie - Kubuś Puchatek, Prosiaczek, Królik, Kłapouchy, Sowa Przemądrzała, Tygrysek, Mama Kangurzyca i Maleństwo - mają odmienne charaktery i różnie się zachowują, jednak każdy z nich to portret jakiegoś często spotykanego rodzaju ludzkich zachowań. Każde z opowiadań pokazuje jakąś ważną prawdę na temat ludzi i ich wzajemnych relacji. Całość składa się na opowieść o tym, że choć każdy człowiek jest inny, to jednak warto próbować się porozumieć, gdyż tylko tak można znaleźć prawdziwych przyjaciół. Wiele osób okazuje się bowiem zupełnie innych, gdy ich poznamy, niż na pierwszy rzut oka. Drugim ważnym wnioskiem z lektury książki jest ten, że choć wszyscy mamy jakieś wady, to nie należy nikogo z tego powodu skreślać, gdyż oprócz wad każdy ma też jakieś zalety.");
        insertIntoDatabase("Chłopcy z Placu Broni","W Budapeszcie, na jednym z placów przeznaczonych pod zabudowę swoje ulubione miejsce zabaw ma grupa chłopców. Nazwali siebie Chłopcami z Placu Broni. Przewodzi im Janosz Boka. Rywalizuje z nimi inna grupa chłopców - Czerwonoskórzy. Okazuje się, że trzeba będzie stoczyć bitwę o ukochany plac. Zarówno w tej bitwie jak i przed nią odznacza się zwłaszcza jeden z Chłopców w Placu Broni - Ernest Nemeczek. Najpierw wyprawia się do Ogrodu Botanicznego, gdzie Czerwonoskórzy mają swoją siedzibę i dowiaduje się, że należący do ich grupy Gereb, zdradził. Zostaje za to skąpany w stawie i ciężko choruje. Mimo to w dzień bitwy pojawia się na Placu, by go bronić. Nemeczek to mały bohater. W finale powieści umiera.");
        insertIntoDatabase("Dżuma","W algierskim mieście Oran wybucha epidemia dżumy. Na dziewięć miesięcy miasto staje się areną walki o przetrwanie. Wobec dżumy, która staje się symbolem śmierci, zła, ludzie zajmują różne postawy. Główny bohater powieści, doktor Bernard Rieux, z oddaniem walczy o życie swoich pacjentów. Robi to w imię zwykłej ludzkiej solidarności, chce nieść ulgę w cierpieniu. Pomagają mu: Grand - urzędnik merostwa i dziennikarz - Rajmond Rambert. Są jednak tacy, którzy uważają, że dżuma jest słuszną karą za występki mieszkańców Oranu. Płomienne kazania na ten temat wygłasza ksiądz Panneloux. Jest agresywny, skostniały w swoich poglądach fanatyka religijnego. Przy łóżku cierpiącego dziecka przeżywa wielką przemianę i podejmuje walkę z chorobą. Pomaga w walce z dżumą. Sam na nią umiera.");
        insertIntoDatabase("Ferdydurke","Powieść Ferdydurke dotyczy najogólniej mówiąc funkcjonowania jednostki w społeczeństwie. Główny bohater powieści - Józio Kowalski, trzydziestoletni mężczyzna - zostaje pewnego ranka zaprowadzony do szkoły przez profesora Pimkę. Szkoła jest miejscem „upupiania”, poprzez wpajanie dobrych obyczajów i wychowywanie w stanie „nieświadomości”. Chłopcy posługują się dziwnym językiem, używają archaizmów. Uczniowie buntują się poprzez używanie wulgaryzmów, ale to tylko potwierdza ich naiwność. W obronie niewinności staje tylko jeden z nich Syfon. Dochodzi do bójki. „Nieuświadomiony” Syfon przegrywa i na następnej przerwie zostanie siłą uświadomiony.");
    }

    private void insertIntoDatabase(String tittle, String text) {
        Texts text1 = new Texts(tittle, text);
        List<Texts> textsList = (List<Texts>) textsRepository.findAll();

        Optional<Texts> alreadyExistInDatabase = textsList.stream()
                .filter(s -> s.getText().equals(text))
                .filter(s -> s.getTittle().equals(tittle))
                .findAny();
        if (!alreadyExistInDatabase.isPresent()) {
            textsRepository.save(text1);
        } else {
            System.out.println(alreadyExistInDatabase.get().getTittle() + " --- is already in database");
        }

    }
}
