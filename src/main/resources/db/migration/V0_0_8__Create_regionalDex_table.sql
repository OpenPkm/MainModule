CREATE TABLE public."regional_dex" (
    id          UUID    NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    pokemon_id  UUID    NOT NULL,
    region_id   UUID    NOT NULL,
    regional_no INTEGER NOT NULL,

    FOREIGN KEY (pokemon_id) REFERENCES public.pokemon(id),
    FOREIGN KEY (region_id)  REFERENCES public.region(id)
);