CREATE TABLE IF NOT EXISTS public.users
(
    uuid character varying COLLATE pg_catalog."default" NOT NULL,
    id character varying(10) COLLATE pg_catalog."default" NOT NULL,
    password character varying(500) COLLATE pg_catalog."default" NOT NULL,
    auth_level character varying(5) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (uuid),
    CONSTRAINT users_idkey UNIQUE (id)
        INCLUDE(id)
)

CREATE TABLE IF NOT EXISTS public.expense
(
    seq integer NOT NULL DEFAULT nextval('account_seq_seq'::regclass),
    fix_value integer DEFAULT 0,
    var_value integer DEFAULT 0,
    agg_date date NOT NULL DEFAULT now(),
    CONSTRAINT account_pkey PRIMARY KEY (seq)
)