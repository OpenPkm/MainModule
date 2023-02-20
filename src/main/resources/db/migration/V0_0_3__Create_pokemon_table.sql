CREATE TABLE public.pokemon (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	national_dex_no int4 NOT NULL,
	"name" varchar NOT NULL,
	classification varchar NOT NULL,
	weight float8 NOT NULL,
	height float8 NOT NULL,
	female_ratio float8 NULL,
	variation varchar NULL,
	CONSTRAINT pokemon_nation_dex_no_un UNIQUE (national_dex_no),
	CONSTRAINT pokemon_pkey PRIMARY KEY (id)
);