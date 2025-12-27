CREATE TABLE tasks (
    id BIGSERIAL PRIMARY KEY,

    title_task VARCHAR(255) NOT NULL,
    description TEXT,

    status VARCHAR(50) NOT NULL,
    priority VARCHAR(50) NOT NULL,

    due_date DATE NOT NULL,
    start_date DATE NOT NULL,

    creator_task_id BIGINT,
    project_id BIGINT
);
