-- Table: public.expense

-- DROP TABLE IF EXISTS public.expense;

CREATE TABLE IF NOT EXISTS public.expense
(
    seq integer NOT NULL DEFAULT nextval('account_seq_seq'::regclass),
    fix_amt integer DEFAULT 0,
    var_amt integer DEFAULT 0,
    agg_date date NOT NULL DEFAULT now(),
    CONSTRAINT account_pkey PRIMARY KEY (seq)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.expense
    OWNER to postgres;

-- Table: public.expense_detail

-- DROP TABLE IF EXISTS public.expense_detail;

CREATE TABLE IF NOT EXISTS public.expense_detail
(
    seq integer NOT NULL DEFAULT nextval('account_seq_seq'::regclass),
    amount integer NOT NULL,
    use_code character varying(10) COLLATE pg_catalog."default" NOT NULL,
    etc text COLLATE pg_catalog."default",
    reg_ym character(8) COLLATE pg_catalog."default" NOT NULL,
    reg_date date DEFAULT now(),
    mod_date date DEFAULT now(),
    CONSTRAINT expense_detail_pkey PRIMARY KEY (seq)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.expense_detail
    OWNER to postgres;

-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

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

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;