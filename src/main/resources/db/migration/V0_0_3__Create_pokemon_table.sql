CREATE TABLE public.pokemon (
	id uuid NOT NULL,
	national_dex_no int NOT NULL,
	"name" varchar NOT NULL,
	classification varchar NOT NULL,
	weight float NOT NULL,
	height float NOT NULL,
	female_ratio float NULL,
	variation varchar NULL,
	CONSTRAINT pokemon_pk PRIMARY KEY (id)
);