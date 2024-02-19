INSERT INTO public.regional_dex(pokemon_id, region_id, regional_no)
(
    select
        id as pokemon_id,
        '1d59b79c-266e-4ed7-9121-fa35b3c922f3' as region_id,
        regional_dex_no as regional_no
    from
        public.pokemon
);
