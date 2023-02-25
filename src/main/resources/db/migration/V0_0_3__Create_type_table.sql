CREATE TABLE public."type" (
	id               uuid       NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	"name"           varchar    NOT NULL,
	slug             varchar(3) NOT NULL,
	background_color varchar    NOT NULL,
	foreground_color varchar    NOT NULL
);