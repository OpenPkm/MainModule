CREATE TABLE public.gen (
	id     uuid    NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	"no"   int     NOT NULL,
	"name" varchar NOT NULL
);