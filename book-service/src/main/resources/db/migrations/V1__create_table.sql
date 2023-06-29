CREATE TABLE public.book
(
    id         VARCHAR(255) NOT NULL,
    title      VARCHAR(255) NOT NULL,
    author     VARCHAR(255) NOT NULL,
    isbn       VARCHAR(255) NOT NULL,
    press_name VARCHAR(255) NOT NULL,
    book_year  INTEGER      NOT NULL,
    CONSTRAINT pk_book PRIMARY KEY (id)
);