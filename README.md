# TDT4100 Tidligere Eksamener

Samling av tidligere eksamener for TDT4100 - Objektorientert programmering ved NTNU.

## Struktur

Prosjektet er organisert i to hovedmapper:

### Oppgaver (`oppgaver/`)
Eksamensoppgaver uten løsninger - for øving.

(Legg merke til at det mangler LF for ord-2019 og ord-2020)


#### Ordinære eksamener
- [ord-2019](oppgaver/ord-2019/) - Ordinær eksamen 2019
- [ord-2020](oppgaver/ord-2020/) - Ordinær eksamen 2020
- [ord-2021](oppgaver/ord-2021/) - Ordinær eksamen 2021
- [ord-2022](oppgaver/ord-2022/) - Ordinær eksamen 2022
- [ord-2023](oppgaver/ord-2023/) - Ordinær eksamen 2023
- [ord-2024-1](oppgaver/ord-2024-1/) - Ordinær eksamen 2024 (variant 1)
- [ord-2024-2](oppgaver/ord-2024-2/) - Ordinær eksamen 2024 (variant 2)
- [ord-2025-1](oppgaver/ord-2025-1/) - Ordinær eksamen 2025 (variant 1)
- [ord-2025-2](oppgaver/ord-2025-2/) - Ordinær eksamen 2025 (variant 2)

#### Kontinuasjonseksamener
- [kont-2020](oppgaver/kont-2020/) - Kontinuasjonseksamen 2020
- [kont-2021](oppgaver/kont-2021/) - Kontinuasjonseksamen 2021
- [kont-2022](oppgaver/kont-2022/) - Kontinuasjonseksamen 2022
- [kont-2023](oppgaver/kont-2023/) - Kontinuasjonseksamen 2023
- [kont-2024](oppgaver/kont-2024/) - Kontinuasjonseksamen 2024

### Løsningsforslag (`løsningsforslag/`)
Komplette løsningsforslag for å sjekke dine svar.

(Legg merke til at det mangler LF for ord-2019 og ord-2020)

#### Ordinære eksamener
- [ord-2021-lf](løsningsforslag/ord-2021-lf/) - Løsningsforslag ordinær 2021
- [ord-2022-lf](løsningsforslag/ord-2022-lf/) - Løsningsforslag ordinær 2022
- [ord-2023-lf](løsningsforslag/ord-2023-lf/) - Løsningsforslag ordinær 2023
- [ord-2024-1-lf](løsningsforslag/ord-2024-1-lf/) - Løsningsforslag ordinær 2024 (variant 1)
- [ord-2024-2-lf](løsningsforslag/ord-2024-2-lf/) - Løsningsforslag ordinær 2024 (variant 2)
- [ord-2025-1-lf](løsningsforslag/ord-2025-1-lf/) - Løsningsforslag ordinær 2025 (variant 1)
- [ord-2025-2-lf](løsningsforslag/ord-2025-2-lf/) - Løsningsforslag ordinær 2025 (variant 2)

#### Kontinuasjonseksamener
- [kont-2020-lf](løsningsforslag/kont-2020-lf/) - Løsningsforslag kont 2020
- [kont-2021-lf](løsningsforslag/kont-2021-lf/) - Løsningsforslag kont 2021
- [kont-2022-lf](løsningsforslag/kont-2022-lf/) - Løsningsforslag kont 2022
- [kont-2023-lf](løsningsforslag/kont-2023-lf/) - Løsningsforslag kont 2023
- [kont-2024-lf](løsningsforslag/kont-2024-lf/) - Løsningsforslag kont 2024

## Prosjektstruktur

Hver eksamen er et Maven-prosjekt med følgende struktur:
- `src/main/java/` - Kildekode og oppgavefiler
- `src/test/java/` - Enhetstester
- `src/main/resources/` - Ressursfiler (CSV, TXT, etc.)
- `pom.xml` - Maven konfigurasjon

## Bruk

1. Åpne ønsket eksamen i din IDE (VSCode, IntelliJ, Eclipse)
2. Les README.md i eksamensmappen for oppgavebeskrivelser
3. Implementer løsninger i TODO-merkede seksjoner
4. Kjør tester for  verifisere implementasjonen

## Kjøre tester

```bash
# Naviger til ønsket eksamen
cd ord-2025-1

# Kjør alle tester
mvn test

# Kjør spesifikk testklasse
mvn test -Dtest=Task1Test
```

## Emner som dekkes

- Grunnleggende Java-syntaks
- Objektorientert programmering (arv, grensesnitt, innkapsling)
- Generics og Collections
- Fil I/O
- Designmnstre (Observer, etc.)
- Unntakshåndtering
- Streams og lambda-uttrykk