CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE TABLE organization (
                              id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

                              name VARCHAR(255) NOT NULL UNIQUE,

                              created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
                              updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);



CREATE TABLE app_user (
                          id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

                          organization_id UUID,

                          email VARCHAR(255) NOT NULL UNIQUE,
                          first_name VARCHAR(100),
                          last_name VARCHAR(100),

                          created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),

                          CONSTRAINT fk_user_organization
                              FOREIGN KEY (organization_id)
                                  REFERENCES organization(id)
);



CREATE UNIQUE INDEX ux_user_email
    ON app_user(email);



CREATE TABLE candidate (
                           id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

                           organization_id UUID NOT NULL,

                           first_name VARCHAR(100) NOT NULL,
                           last_name VARCHAR(100) NOT NULL,
                           email VARCHAR(255) UNIQUE,

                           created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),

                           CONSTRAINT fk_candidate_organization
                               FOREIGN KEY (organization_id)
                                   REFERENCES organization(id)
);



CREATE TABLE interview_template (
                                    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

                                    organization_id UUID NOT NULL,

                                    name VARCHAR(255) NOT NULL UNIQUE,
                                    description TEXT,

                                    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),

                                    CONSTRAINT fk_template_organization
                                        FOREIGN KEY (organization_id)
                                            REFERENCES organization(id)
);



CREATE TABLE interview (
                           id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

                           candidate_id UUID NOT NULL,
                           template_id UUID NOT NULL,

                           status VARCHAR(50) NOT NULL,

                           started_at TIMESTAMP WITH TIME ZONE,
                           finished_at TIMESTAMP WITH TIME ZONE,

                           created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),

                           CONSTRAINT fk_interview_candidate
                               FOREIGN KEY(candidate_id)
                                   REFERENCES candidate(id),

                           CONSTRAINT fk_interview_template
                               FOREIGN KEY(template_id)
                                   REFERENCES interview_template(id)
);



CREATE TABLE interview_stage (
                                 id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

                                 interview_id UUID NOT NULL,

                                 type VARCHAR(50) NOT NULL,

                                 order_number INTEGER NOT NULL,

                                 status VARCHAR(50) NOT NULL,

                                 created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),

                                 CONSTRAINT fk_stage_interview
                                     FOREIGN KEY(interview_id)
                                         REFERENCES interview(id)
);