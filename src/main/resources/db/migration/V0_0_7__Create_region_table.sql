CREATE TABLE public."region" (
    id               UUID        NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    "name"           VARCHAR(50) NOT NULL,
    parent_region_id UUID            NULL,

    CONSTRAINT "fk_region_parent_region_id" FOREIGN KEY (parent_region_id) REFERENCES public."region" (id)
);