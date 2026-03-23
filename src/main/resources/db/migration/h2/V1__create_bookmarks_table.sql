ALTER TABLE IF EXISTS bookmark_tags
    DROP CONSTRAINT IF EXISTS FKrdbrrv4s1a8ybx3jj46i297vb;

DROP TABLE IF EXISTS bookmark_tags CASCADE;
DROP TABLE IF EXISTS bookmarks CASCADE;

CREATE TABLE bookmark_tags (
    bookmark_id uuid NOT NULL,
    tag varchar(255)
);

CREATE TABLE bookmarks (
    created_at timestamp(6) with time zone NOT NULL,
    id uuid NOT NULL,
    title varchar(255) NOT NULL,
    url varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS bookmark_tags
    ADD CONSTRAINT FKrdbrrv4s1a8ybx3jj46i297vb
    FOREIGN KEY (bookmark_id)
    REFERENCES bookmarks;
