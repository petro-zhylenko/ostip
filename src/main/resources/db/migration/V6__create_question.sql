CREATE TABLE question (

                          id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

                          organization_id UUID NOT NULL,

                          title VARCHAR(500) NOT NULL,

                          description TEXT NOT NULL,

                          expected_answer TEXT,

                          difficulty VARCHAR(50),

                          category VARCHAR(100),

                          created_at TIMESTAMP WITH TIME ZONE DEFAULT now(),

                          CONSTRAINT fk_question_org
                              FOREIGN KEY(organization_id)
                                  REFERENCES organization(id)
);

CREATE TABLE template_stage_question (

                                         stage_id UUID NOT NULL,

                                         question_id UUID NOT NULL,

                                         order_number INTEGER NOT NULL,

                                         weight INTEGER DEFAULT 1,

                                         PRIMARY KEY(stage_id, question_id),

                                         CONSTRAINT fk_stage_question_stage
                                             FOREIGN KEY(stage_id)
                                                 REFERENCES interview_template_stage(id),

                                         CONSTRAINT fk_stage_question_question
                                             FOREIGN KEY(question_id)
                                                 REFERENCES question(id)
);