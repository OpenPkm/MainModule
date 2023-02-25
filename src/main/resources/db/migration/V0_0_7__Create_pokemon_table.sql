CREATE TABLE public.pokemon (
	id                uuid    NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	"name"            varchar NOT NULL,
	gen_id            uuid    NOT NULL,
	national_dex_no   int4    NOT NULL,
	regional_dex_no   int4    NOT NULL,
	classification    varchar NOT NULL,
	weight            float8  NOT NULL,
	height            float8  NOT NULL,
	female_ratio      float8      NULL,
	variation         varchar     NULL,
	primary_type_id   uuid    NOT NULL,
	secondary_type_id uuid        NULL,
	CONSTRAINT gen_id_fk FOREIGN KEY (gen_id) REFERENCES public."gen"(id),
	CONSTRAINT primary_type_id_fk FOREIGN KEY (primary_type_id) REFERENCES public."type"(id),
	CONSTRAINT secondary_type_id_fk FOREIGN KEY (secondary_type_id) REFERENCES public."type"(id)
);
